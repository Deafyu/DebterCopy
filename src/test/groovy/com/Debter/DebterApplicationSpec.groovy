package com.Debter

import com.Debter.domain.DebeterFacadeCreator
import com.Debter.domain.DebterFacade
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
        debterFacade.addNewTransaction(user1.getUserId(), user.getUserId(), 20L)
        debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 30L)
        debterFacade.addNewTransaction(4L, user1.getUserId(), 30L)
        when: "user ask for history of transactions"
        List<TransactionDto> list = debterFacade.getEntireHistoryOfTransactions(user.getUserId(), user1.getUserId())
        then: "he receives history"
        list.size() == 3
    }

    def "system can sort out the transactions by date"() {
        given: "there are users wich have done some transactions"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        Thread.sleep(1)
        debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 30L)
        Thread.sleep(1)
        debterFacade.addNewTransaction(user1.getUserId(), user.getUserId(), 20L)
        Thread.sleep(1)
        debterFacade.addNewTransaction(user1.getUserId(), user.getUserId(), 40L)
        List<TransactionDto> list2 = debterFacade.getEntireHistoryOfTransactions(user.getUserId(), user1.getUserId())
        when: "when system is asked to sort them"
        List<TransactionDto> list = debterFacade.sortHistoryByDate(list2)
        then: "it gets sorted history"
        list.get(0).getMoney() == 40L
        list.get(1).getMoney() == 20L
        list.get(2).getMoney() == 30L
        list.get(3).getMoney() == 10L
    }

    def "user is able to add a new friend to his friendList"() {
        given: "there are 2 users"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        when: "one accepts the offer sent by the 2nd one"
        Long relationId = debterFacade.addNewRelation(user.getUserId(), user1.getUserId())
        then: "their relation is added to the db"
        debterFacade.getRelation(relationId) != null
    }

    def "user is able to delete another user form his friend list"() {
        given: "there are 2 users wich are friends"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        when: "1 user deletes another"
        Long relationId = debterFacade.addNewRelation(user.getUserId(), user1.getUserId())
        debterFacade.setUserRelation(relationId, false)
        then: "there are no more friends"
        !debterFacade.getRelation(relationId).getAreFriends()
    }

    def "transaction can be payedBack"() {
        given: "there is a transaction"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        Long transactionId = debterFacade.addNewTransaction(user.getUserId(), user1.getUserId(), 10L)
        when: "when transaction is payed back"
        debterFacade.payTransaction(transactionId, true)
        then: "it has been payed back"
        debterFacade.getTransaction(transactionId).getPayedBack()
    }

    def "user can log in"() {
        given: "there is a user"
        Long userId = debterFacade.addNewUser()
        when: "when he logs in"
        debterFacade.logInUser(userId, true)
        then: "he has loged in"
        debterFacade.getUser(userId).getLogedIn()
    }

    def "user acc is no longer active"(){
        given:"there is user"
        Long userId = debterFacade.addNewUser()
        when:"user deletes his acc"
        debterFacade.deleteAccount(userId,false)
        then:"his acc is no longer active"
        !debterFacade.getUser(userId).getAccountActive()
    }
}
