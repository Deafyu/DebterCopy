package com.UserRelation

import com.Debter.domain.UserRelation.domain.UserRelation
import com.Debter.domain.UserRelation.domain.UserRelationRepository

class InMemoryUserRelationRepository implements UserRelationRepository{

    Map<Long, UserRelation> usersRelations = new HashMap<>()

    @Override
    Long createNewRelation(Long userId, Long userId2, Date date) {

        Random random = new Random()
        Long relationId = random.nextLong()

        usersRelations.put(relationId, UserRelation.builder()
                .relationId(relationId)
                .userId(userId)
                .userId2(userId2)
                .date(date)
                .areFriends(true)
                .build()
        )

        return relationId
    }

    @Override
    Optional<UserRelation> findRelationById(Long relationId) {

        return Optional.ofNullable(usersRelations.get(relationId))
    }

    @Override
    void setAreFriendsStatus(Long relationId, boolean relationStatus) {
        usersRelations.get(relationId).setAreFriends(relationStatus)
    }
}
