package com.thupq.mypets.service;

import com.thupq.mypets.models.entity.transaction.Transaction;
import com.thupq.mypets.models.request.TransactionRequest;

public interface TransactionService {
    Transaction create(TransactionRequest request);

    Transaction getDetails(Long id);
}
