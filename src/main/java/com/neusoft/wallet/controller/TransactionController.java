package com.neusoft.wallet.controller;

import com.neusoft.wallet.common.base.BaseController;
import com.neusoft.wallet.common.base.BaseModel;
import com.neusoft.wallet.common.base.BaseModelJson;
import com.neusoft.wallet.common.exception.BusinessException;
import com.neusoft.wallet.wallet.entity.Transaction;
import com.neusoft.wallet.wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController extends BaseController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/recordlist")
    public BaseModelJson<List<Transaction>> recordlist(){
        List<Transaction> list = transactionService.getList();
        BaseModelJson<List<Transaction>> result = new BaseModelJson<List<Transaction>>();
        result.code = 200;
        result.message = "fetch success";
        result.data = list;
        return result;
    }

    @GetMapping("/userrecordlist")
    public BaseModelJson<List<Transaction>> userrecordlist(@RequestParam int buyer_id){
        List<Transaction> list = transactionService.getUserList(buyer_id);
        BaseModelJson<List<Transaction>> result = new BaseModelJson<List<Transaction>>();
        result.code = 200;
        result.message = "fetch success";
        result.data = list;
        return result;
    }

    @GetMapping("/auditlist")
    public BaseModelJson<List<Transaction>> auditlist(){
        List<Transaction> list = transactionService.getAuditList();
        BaseModelJson<List<Transaction>> result = new BaseModelJson<List<Transaction>>();
        result.code = 200;
        result.message = "fetch success";
        result.data = list;
        return result;
    }

    @PostMapping("/audit")
    public BaseModel audit(@RequestParam int transaction_id,@RequestParam int result_code){
        if(transactionService.audit(transaction_id,result_code)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "audit success";
            return result;
        }else{
            throw BusinessException.UPDATE_FAIL;
        }
    }

    @PostMapping("/insert")
    public BaseModel insert(@RequestBody Transaction transaction){
        if(transactionService.insert(transaction)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "audit success";
            return result;
        }else{
            throw BusinessException.INSERT_FAIL;
        }
    }

}
