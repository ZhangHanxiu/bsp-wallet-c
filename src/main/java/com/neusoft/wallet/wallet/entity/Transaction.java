package com.neusoft.wallet.wallet.entity;

import java.sql.Date;

public class Transaction {
    int transaction_id;
    int buyer_id;
    float transaction_money;
    int transaction_type;//业务类型 1-充值 2-提现 3-消费 4-退款
    String account_name;
    int status;//状态 2 -待审核 , 4 -审计通过 , 1 -审核拒绝


    Date transaction_time;

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public float getTransaction_money() {
        return transaction_money;
    }

    public void setTransaction_money(float transaction_money) {
        this.transaction_money = transaction_money;
    }

    public int getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(int transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Date getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(Date transaction_time) {
        this.transaction_time = transaction_time;
    }


    @Override
    public String toString() {
        String type_str;
        String status_str;
        switch(transaction_type){
            case 1:
                type_str = "deposit";
            case 2:
                type_str = "withdraw";
            case 3:
                type_str = "consume";
            case 4:
                type_str = "refund";
            default:
                type_str = "unknown";
        }

        switch(status){
            case 2:
                status_str = "Under appication";
            case 4:
                status_str = "Application approved";
            case 1:
                status_str = "Application refused";
            default:
                status_str = "unknown";
        }


        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", transaction_money=" + transaction_money +
                ", transaction_type=" + type_str +
                ", account_name='" + account_name + '\'' +
                ", status=" + status_str +
                ", transaction_time=" + transaction_time +
                '}';
    }
}
