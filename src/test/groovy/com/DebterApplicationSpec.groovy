package com

import com.Debter.domain.Debter.DebeterFacadeCreator
import com.Debter.domain.Debter.DebterFacade
import com.Transaction.InMemoryTransactionRepository
import com.User.InMemoryUserRepository
import spock.lang.Specification

class DebterApplicationSpec extends Specification {

    DebterFacade debterFacade = new DebeterFacadeCreator().createDebeterFacade(new InMemoryTransactionRepository(), new InMemoryUserRepository())

    def "check for sufficient funds"() {
        given: "there are 2 users"

        when: "when system check user funds"

        then: "funds have been checked"
        debterFacade.checkFunds()
    }
}
