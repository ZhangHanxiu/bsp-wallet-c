package com.neusoft.wallet.wallet.service.Impl;

import com.neusoft.wallet.wallet.entity.Transaction;
import com.neusoft.wallet.wallet.service.TransactionService;
import com.neusoft.wallet.wallet.mapper.TransationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransationMapper transationMapper;

    @Override
    public List<Transaction> getList() {
        return transationMapper.getList();
    }

    @Override
    public List<Transaction> getUserList(int buyer_id) {
        return transationMapper.getUserList(buyer_id);
    }

    @Override
    public List<Transaction> getAuditList() {
        return transationMapper.getAuditList();
    }

    @Override
    public int audit(int transaction_id, int result_code) {
        return transationMapper.audit(transaction_id,result_code);
    }

    @Override
    public int insert(Transaction transaction) {
        return transationMapper.insert(transaction);
    }
}
