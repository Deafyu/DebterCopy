package com.UserRelation;

import com.Debter.domain.UserRelation.domain.UserRelation;
import com.Debter.domain.UserRelation.domain.UserRelationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class InMemoryUserRelationRepository implements UserRelationRepository{

    private Map<Long, UserRelation> usersRelations = new HashMap<>();

    @Override
    public List<UserRelation> findAll() {
        return null;
    }

    @Override
    public List<UserRelation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserRelation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserRelation> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserRelation userRelation) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserRelation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends UserRelation> S save(S relation) {
        usersRelations.put(relation.getRelationId(),relation);
        return null;
    }

    @Override
    public <S extends UserRelation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<UserRelation> findById(Long relationId) {
        return Optional.ofNullable(usersRelations.get(relationId));

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserRelation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<UserRelation> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserRelation getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends UserRelation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserRelation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserRelation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserRelation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserRelation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserRelation> boolean exists(Example<S> example) {
        return false;
    }
}
