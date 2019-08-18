package com.UserRelation

import com.Debter.domain.UserRelation.domain.UserRelation
import com.Debter.domain.UserRelation.domain.UserRelationRepository

class InMemoryUserRelationRepository implements UserRelationRepository{

    Map<Long, UserRelation> usersRelations = new HashMap<>()

    @Override
    Optional<UserRelation> findRelationById(Long relationId) {

        return Optional.ofNullable(usersRelations.get(relationId))
    }

    @Override
    void saveUserRelation(UserRelation relation) {
        usersRelations.put(relation.getRelationId(),relation)
    }
}
