package com.neusoft.wallet.wallet.mapper;

import com.neusoft.wallet.wallet.entity.WalletAccount;
import com.neusoft.wallet.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletAccountMapper extends BaseMapper<Integer, WalletAccount> {
    WalletAccount getByName(String accountname);

    int updateFund(int buyer_id, float amount);

    float fund(int buyer_id);

    int getIdByName(String name);
}
