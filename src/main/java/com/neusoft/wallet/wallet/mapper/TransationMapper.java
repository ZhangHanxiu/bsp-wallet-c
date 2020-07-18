package com.neusoft.wallet.wallet.mapper;

import com.neusoft.wallet.common.base.BaseMapper;
import com.neusoft.wallet.wallet.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransationMapper extends BaseMapper<Integer, Transaction> {
    List<Transaction> getList();
    List<Transaction> getAuditList();

    int audit(int transaction_id, int result_code);

    List<Transaction> getUserList(int buyer_id);
}
