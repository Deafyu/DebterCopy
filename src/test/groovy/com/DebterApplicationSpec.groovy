package com

import com.Debter.domain.Debter.DebeterFacadeCreator
import com.Debter.domain.Debter.DebterFacade
import com.Debter.domain.Transaction.domain.TransactionFacade
import com.Debter.domain.Transaction.domain.TransactionFacadeCreator
import com.Debter.domain.User.domain.UserFacade
import com.Debter.domain.User.domain.UserFacadeCreator
import com.Transaction.InMemoryTransactionRepository
import com.User.InMemoryUserRepository
import spock.lang.Specification

class DebterApplicationSpec extends Specification {

    InMemoryUserRepository imur = new InMemoryUserRepository()
    DebterFacade debterFacade = new DebeterFacadeCreator().createDebeterFacade(new InMemoryTransactionRepository(), imur)
    UserFacade userFacade = new UserFacadeCreator().createUserFacade(imur)
    TransactionFacade transactionFacade = new TransactionFacadeCreator().createTransactionFacade(new InMemoryTransactionRepository() {
    })

    def "deny when no sufficient funds"() {
        given: "there are is a user"
        Long userId = userFacade.addNewUser()
        when: "when funds are requested"

        // Do uzupełnienia z requestem

        userFacade.addFunds(userId, 10L)

        then: "funds have been checked"
        !debterFacade.checkFunds(userId, 15L)
    }
}
