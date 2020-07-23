package com.neusoft.wallet.wallet.service.Impl;

import com.neusoft.wallet.wallet.entity.WalletAccount;
import com.neusoft.wallet.wallet.service.WalletAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WalletAccountServiceTest {

    @Autowired
    WalletAccountService walletAccountService;

    @Test
    void getByName() {
        assertNotNull(walletAccountService.getByName("wx"));
    }

    @Test
    void insert() {
        WalletAccount walletAccount = new WalletAccount();
        walletAccount.setAccount_name("test07230829");
        walletAccount.setPassword("171024");
        assertEquals(1,(walletAccountService.insert(walletAccount)));
    }



    @Test
    void withdraw() {
    }

    @Test
    void deposit() {
    }

    @Test
    void fund() {
    }
}
