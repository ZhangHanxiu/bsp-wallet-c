package com.neusoft.wallet.wallet.service.Impl;

import com.github.pagehelper.PageInfo;
import com.neusoft.wallet.wallet.entity.WalletAccount;
import com.neusoft.wallet.wallet.mapper.WalletAccountMapper;
import com.neusoft.wallet.wallet.service.WalletAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WalletAccountServiceImpl implements WalletAccountService {

    @Autowired
    WalletAccountMapper walletAccountMapper;


    @Override
    public WalletAccount getByName(String accountname) {
        return walletAccountMapper.getByName(accountname);
    }

    @Override
    public int insert(WalletAccount walletAccount) {
        return walletAccountMapper.insert(walletAccount);
    }

    @Override
    public int update(WalletAccount walletAccount) {
        return 0;
    }

    @Override
    public int delete(String walletid) {
        return 0;
    }

    @Override
    public WalletAccount getById(String walletid) {
        return null;
    }

    @Override
    public List<WalletAccount> getAll() {
        return null;
    }

    @Override
    public List<WalletAccount> getAllByFilter(Map<String, Object> map) {
        return null;
    }

    @Override
    public PageInfo<WalletAccount> getAllByFilter(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public PageInfo<WalletAccount> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        return null;
    }

    @Override
    public int withdraw(int buyer_id, float amount) {
        if(fund(buyer_id)<amount){
            return 0;
        }
        return walletAccountMapper.updateFund(buyer_id,(-1)*amount);
    }

    @Override
    public int deposit(int buyer_id, float amount) {
        return walletAccountMapper.updateFund(buyer_id,amount);
    }

    @Override
    public float fund(int buyer_id) {
        return walletAccountMapper.fund(buyer_id);
    }

    @Override
    public int getIdByName(String name) {
        return walletAccountMapper.getIdByName(name);
    }
}
