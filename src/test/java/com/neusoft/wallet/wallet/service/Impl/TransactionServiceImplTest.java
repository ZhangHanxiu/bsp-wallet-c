package com.neusoft.wallet.wallet.service.Impl;

import com.neusoft.wallet.wallet.entity.Transaction;
import com.neusoft.wallet.wallet.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceImplTest {

    TransactionServiceImpl transactionService;

    @Test
    void insert() {
        Transaction transaction = new Transaction();
        transaction.setBuyer_id(1);
        transaction.setTransaction_type(1);
        transaction.setTransaction_money(10);
        assertEquals(1,transactionService.insert(transaction));
    }

    @Test
    void getList() {
        assertNotNull(transactionService.getList());
    }

    @Test
    void getUserList() {
        assertNotNull(transactionService.getUserList(1));
    }

    @Test
    void getAuditList() {
        assertNotNull(transactionService.getAuditList());
    }

    @Test
    void audit() {
        List<Transaction> list = transactionService.getAuditList();
        int audit_id = list.get(list.size()-1).getTransaction_id();
        assertEquals(1,transactionService.audit(audit_id,4));
    }


}
