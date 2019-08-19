package com.Transaction;

import com.Debter.domain.Transaction.domain.Transaction;
import com.Debter.domain.Transaction.domain.TransactionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

class InMemoryTransactionRepository implements TransactionRepository {

    private Map<Long, Transaction> transactions = new HashMap<>();

    @Override
    public List<Transaction> getAllHistory(Long userId, Long userId2) {

        return new ArrayList<>(transactions.values());
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public List<Transaction> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Transaction> findAllById(Iterable<Long> iterable) {
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
    public void delete(Transaction transaction) {

    }

    @Override
    public void deleteAll(Iterable<? extends Transaction> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Transaction> S save(S transaction) {
        transactions.put(transaction.getTransactionId(),transaction);
        return null;
    }

    @Override
    public <S extends Transaction> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Transaction> findById(Long transactionId) {
        return Optional.ofNullable(transactions.get(transactionId));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Transaction> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Transaction> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Transaction getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Transaction> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Transaction> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Transaction> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Transaction> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Transaction> boolean exists(Example<S> example) {
        return false;
    }
}
