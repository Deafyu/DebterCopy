package com.User

import com.Debter.domain.User.domain.UserFacade
import com.Debter.domain.User.domain.UserFacadeCreator
import spock.lang.Specification

class UserSpec extends Specification{

    UserFacade userFacade = new UserFacadeCreator().createUserFacade(new InMemoryUserRepository() {})

    def "User is added by System"() {
        when: "user sings up"
        Long userId = userFacade.addNewUser()
        then: "he has been added to db"
        userFacade.getUser(userId) != null
    }

    def "user can log in"() {
        given: "there is a user"
        Long userId = userFacade.addNewUser()
        when: "when he logs in"
        userFacade.logInUser(userId, true)
        then: "he has loged in"
        userFacade.getUser(userId).getLogedIn()
    }

    def "user acc is no longer active"(){
        given:"there is user"
        Long userId = userFacade.addNewUser()
        when:"user deletes his acc"
        userFacade.deactivateAccount(userId,false)
        then:"his acc is no longer active"
        !userFacade.getUser(userId).getAccountActive()
    }

    def "user can add new funds to his acc"() {
        given: "there is user"
        Long userId = userFacade.addNewUser()
        when: "user adds funds to his acc"
        userFacade.addFunds(userId, 10L)
        then: "funds have been added"
        userFacade.getUser(userId).getUserFunds() == 10L
    }

    def "remove funds from user acc"() {
        given: "there is user"
        Long userId = userFacade.addNewUser()
        when: "user adds funds to his acc"
        userFacade.removeFunds(userId, 10L)
        then: "funds have been removed"
        userFacade.getUser(userId).getUserFunds() == -10L
    }
}

