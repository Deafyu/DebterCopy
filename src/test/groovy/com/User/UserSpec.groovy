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
        userFacade.deleteAccount(userId,false)
        then:"his acc is no longer active"
        !userFacade.getUser(userId).getAccountActive()
    }
}

