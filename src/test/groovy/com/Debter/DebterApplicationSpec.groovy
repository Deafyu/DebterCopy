package com.Debter

import com.Debter.domain.DebeterFacadeCreator
import com.Debter.domain.DebterFacade
import com.Debter.domain.Transaction
import com.Debter.domain.User
import com.Debter.dto.TransactionDto
import spock.lang.Specification

class DebterApplicationSpec extends Specification {

    DebterFacade debterFacade = new DebeterFacadeCreator().createDebeterFacade(new InMemoryDebterRepository() {})
    User user = Stub(User)
    User user1 = Stub(User)


    def "User is added by System"() {
        when: "user sings up"
        Long userId = debterFacade.addNewUser()
        then: "he has been added to db"
        debterFacade.getUser(userId) != null
    }

    def "transaction is added to db"() {
        given: "there are 2 users"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        when: "one lends to another"
        Long transactionId = debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        then: "transaction has been added"
        debterFacade.getTransaction(transactionId) != null
    }


    def "user is able to get specific history of transactions with another user"() {
        given: "there are 2 users with some transactions"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 20L)
        debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 30L)
        when: "user ask for history of transactions"
        List<TransactionDto> list = debterFacade.getEntireHistoryOfTransactions(user.getUserId(), user1.getUserId())
        then: "he receives history"
    }
}
