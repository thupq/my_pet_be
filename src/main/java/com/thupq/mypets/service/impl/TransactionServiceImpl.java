package com.thupq.mypets.service.impl;

import com.thupq.mypets.models.entity.transaction.Transaction;
import com.thupq.mypets.models.request.TransactionRequest;
import com.thupq.mypets.repository.transaction.TransactionRepository;
import com.thupq.mypets.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;


    @Override
    public Transaction create(TransactionRequest request) {
        long id = System.currentTimeMillis();
        Transaction transaction = Transaction.create(request, id);
        return repository.save(transaction);
    }

    @Override
    public Transaction getDetails(Long id) {
        Optional<Transaction> transaction = repository.findById(id);
        return transaction.get();
    }
}
