package com.UserRelation

import com.Debter.domain.User.domain.User
import com.Debter.domain.UserRelation.domain.UserRelationFacade
import com.Debter.domain.UserRelation.domain.UserRelationFacadeCreator
import spock.lang.Specification

class UserRelationSpec extends Specification {

    UserRelationFacade userRelationFacade = new UserRelationFacadeCreator().createUserRelationFacade(new InMemoryUserRelationRepository() {})
    User user = Stub(User)
    User user1 = Stub(User)

    def "user is able to add a new friend to his friendList"() {
        given: "there are 2 users"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        when: "one accepts the offer sent by the 2nd one"
        Long relationId = userRelationFacade.addNewRelation(user.getUserId(), user1.getUserId())
        then: "their relation is added to the db"
        userRelationFacade.findRelationById(relationId) != null
    }

    def "user is able to delete another user form his friend list"() {
        given: "there are 2 users wich are friends"
        user.getUserId() >> 1L
        user1.getUserId() >> 2L
        when: "1 user deletes another"
        Long relationId = userRelationFacade.addNewRelation(user.getUserId(), user1.getUserId())
        userRelationFacade.setFriendStatus(relationId, false)
        then: "there are no more friends"
        !userRelationFacade.findRelationById(relationId).getAreFriends()
    }
}
