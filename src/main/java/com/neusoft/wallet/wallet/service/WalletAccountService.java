package com.neusoft.wallet.wallet.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.wallet.common.base.BaseModel;
import com.neusoft.wallet.wallet.entity.WalletAccount;

import java.util.List;
import java.util.Map;

public interface WalletAccountService {


    WalletAccount getByName(String accountname);

    int insert(WalletAccount walletAccount);

    int update(WalletAccount walletAccount);

    int delete(String walletid);

    WalletAccount getById(String walletid);

    List<WalletAccount> getAll();

    List<WalletAccount> getAllByFilter(Map<String, Object> map);

    PageInfo<WalletAccount> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<WalletAccount> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);

    int withdraw(int buyer_id, float amount);

    int deposit(int buyer_id, float amount);

    float fund(int buyer_id);

    int getIdByName(String name);
}
