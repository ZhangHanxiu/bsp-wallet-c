package com.neusoft.wallet.wallet.entity;

public class WalletAccount {
    int buyer_id;
    String account_name;
    String email;
    String password;
    int account_type;
    float available_money;

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_type() {
        return account_type;
    }

    public void setAccount_type(int account_type) {
        this.account_type = account_type;
    }

    public float getAvailable_money() {
        return available_money;
    }

    public void setAvailable_money(float available_money) {
        this.available_money = available_money;
    }

    @Override
    public String toString() {
        return "WalletAccount{" +
                "buyer_id=" + buyer_id +
                ", account_name='" + account_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", account_type='" + account_type + '\'' +
                ", available_money=" + available_money +
                '}';
    }
}
