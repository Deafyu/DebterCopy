package com.Transaction

import com.Debter.domain.Transaction.domain.TransactionFacade
import com.Debter.domain.Transaction.domain.TransactionFacadeCreator
import com.Debter.domain.Transaction.dto.TransactionDto
import com.Debter.domain.User.domain.User
import spock.lang.Specification

class TransactionSpec extends Specification {

    TransactionFacade transactionFacade = new TransactionFacadeCreator().createTransactionFacade(new InMemoryTransactionRepository() {})
    User user = Stub(User)
    User user1 = Stub(User)

    def "transaction is added to db"() {
        given: "there are 2 users"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        when: "one lends to another"
        Long transactionId = transactionFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        then: "transaction has been added"
        transactionFacade.getTransaction(transactionId) != null
    }
    def "user is able to get specific history of transactions with another user"() {
        given: "there are 2 users with some transactions"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        transactionFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        transactionFacade.addNewTransaction(user1.getUserId(), user.getUserId(), 20L)
        transactionFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 30L)
        transactionFacade.addNewTransaction(4L, user1.getUserId(), 30L)
        when: "user ask for history of transactions"
        List<TransactionDto> list = transactionFacade.getHistoryOfTransactions(user.getUserId(), user1.getUserId())
        then: "he receives history"
        list.size() == 3
    }

    def "system can sort out the transactions by date"() {
        given: "there are users wich have done some transactions"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        transactionFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        Thread.sleep(1)
        transactionFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 30L)
        Thread.sleep(1)
        transactionFacade.addNewTransaction(user1.getUserId(), user.getUserId(), 20L)
        Thread.sleep(1)
        transactionFacade.addNewTransaction(user1.getUserId(), user.getUserId(), 40L)
        List<TransactionDto> list2 = transactionFacade.getHistoryOfTransactions(user.getUserId(), user1.getUserId())
        when: "when system is asked to sort them"
        List<TransactionDto> list = transactionFacade.sortHistoryByDate(list2)
        then: "it gets sorted history"
        list.get(0).getMoney() == 40L
        list.get(1).getMoney() == 20L
        list.get(2).getMoney() == 30L
        list.get(3).getMoney() == 10L
    }

    def "transaction can be payedBack"() {
        given: "there is a transaction"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        Long transactionId = transactionFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        when: "when transaction is payed back"
        transactionFacade.payTransaction(transactionId, true)
        then: "it has been payed back"
        transactionFacade.getTransaction(transactionId).getPayedBack()
    }
}
