package com.Debter

import com.Debter.domain.DebeterFacadeCreator
import com.Debter.domain.DebterFacade
import com.Debter.domain.DefaultUser
import com.Debter.dto.DefaultUserDto
import org.apache.catalina.users.AbstractUser
import spock.lang.Specification

class DebterApplicationSpec extends Specification {

    DebterFacade debterFacade = new DebeterFacadeCreator().createDebeterFacade(new InMemoryDebterRepository() {})

    DefaultUser defaultUser = Stub(DefaultUser)

    def "user is can add both lenders and borrowers to his db"(){
        given:"there is a user"
        defaultUser.getUserId()>>5L
        when:"he adds a lender and a burrower"
        debterFacade.addNewBurrower(5L,1L)
        debterFacade.addNewLender(5L,2L)
        then:"both of them have been added"
    }
}
