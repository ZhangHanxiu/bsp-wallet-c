package com.neusoft.wallet.wallet.service;

import com.neusoft.wallet.wallet.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getList();

    List<Transaction> getUserList(int buyer_id);

    List<Transaction> getAuditList();

    int audit(int transaction_id,int result_code);

    int insert(Transaction transaction);
}
