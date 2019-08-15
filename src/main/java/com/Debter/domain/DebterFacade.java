package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import com.Debter.dto.UserDto;
import com.Debter.exceptions.TransactionNotFoundException;
import com.Debter.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

    DebeterRepository debeterRepository;

    public Long addNewTransaction(Long lenderId, Long burrowerId, Long money) {

        return debeterRepository.createNewTransaction(lenderId, burrowerId, money , getCurrentDate());
    }

    public TransactionDto getTransaction(Long transactionId) throws TransactionNotFoundException {

        return debeterRepository.findTransactionById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction :" + transactionId + " not found"))
                .dto();
    }

    public Long addNewUser() {

        return debeterRepository.createNewUser();

    }

    public UserDto getUser(Long userId) throws UserNotFoundException {

        return debeterRepository.findUseById(userId)
                .orElseThrow(() -> new UserNotFoundException("User: " + userId + " not found"))
                .dto();
    }

    public List<TransactionDto> getEntireHistoryOfTransactions(Long userId, Long userId2) {

        List<Transaction> transactions = debeterRepository.getAllHistory(userId, userId2);
        List<TransactionDto> transactionsDto = new ArrayList<>();

        transactions.forEach(transaction -> transactionsDto.add(transaction.dto()));

        return transactionsDto;
    }

    public void sortHistoryByDate(List<TransactionDto> dto) {

        for(int i = 0 ; i <dto.size() ; i++){
            if(dto.get(i).getDate()<dto.get(i+1).getDate()){
                swap(dto.get(i),dto.get(i+1));
            }
        }
    }

    private void swap(Object object1, Object object2) {

        Object tempObject = object1;
        object1 = object2;
        object2 = tempObject;

    }

    public Date getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        Long a = (Long) new Date()
    }
}
