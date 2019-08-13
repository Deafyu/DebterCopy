package com.Debter

import com.Debter.domain.DebeterFacadeCreator
import com.Debter.domain.DebterFacade
import spock.lang.Specification

class DebterApplicationSpec extends Specification {

    DebterFacade debterFacade = new DebeterFacadeCreator().createDebeterFacade(new InMemoryDebterRepository() {})

    def "User is added by System"(){
        when:"user sings up"
        Long userId = debterFacade.addNewUser()
        then:"he has been added to db"
        debterFacade.getUser(userId)!= null
    }
}
