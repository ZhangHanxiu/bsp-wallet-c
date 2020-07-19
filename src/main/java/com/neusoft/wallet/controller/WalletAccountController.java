package com.neusoft.wallet.controller;

import com.neusoft.wallet.common.base.BaseController;
import com.neusoft.wallet.common.base.BaseModel;
import com.neusoft.wallet.common.base.BaseModelJson;
import com.neusoft.wallet.common.exception.BusinessException;
import com.neusoft.wallet.common.util.TokenUtil;
import com.neusoft.wallet.common.validationGroup.InsertGroup;
import com.neusoft.wallet.wallet.entity.WalletAccount;
import com.neusoft.wallet.wallet.service.TransactionService;
import com.neusoft.wallet.wallet.service.WalletAccountService;
import com.neusoft.wallet.wallet.vo.LoginVo;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@CrossOrigin
@RestController
@RequestMapping("/wallet")
public class WalletAccountController  extends BaseController {

    @Autowired
    WalletAccountService walletAccountService;

    @Autowired
    TransactionService transactionService;


    @PostMapping("/register")
    public BaseModel addUser(@Validated({InsertGroup.class}) @RequestBody WalletAccount waa) {
        if (walletAccountService.getByName(waa.getAccount_name()) == null) {
            int i = walletAccountService.insert(waa);
            if (i == 1) {
                BaseModel result = new BaseModel();
                result.code = 200;
                result.message = "Register success";
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }else{
            throw BusinessException.USERNAME_EXISTS;
        }
    }

    @PostMapping("/login")
    public LoginVo checkUser(@RequestParam String accountname, @RequestParam String password, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken uptoken = new UsernamePasswordToken(accountname,password);
        //Set ip
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        try{
            subject.login(uptoken);
            WalletAccount waa = (WalletAccount) subject.getPrincipal();
            LoginVo result = new LoginVo();
            result.code = 200;
            result.data = waa;
            result.message = "login success";
            result.token = TokenUtil.getToken(accountname,waa.getBuyer_id(),ip);
            return result;
        }catch(IncorrectCredentialsException e){
            throw BusinessException.PASSWORD_WRONG;
        }catch(UnknownAccountException e){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
    }

    @PostMapping("/withdraw")
    public BaseModel withdraw(@RequestParam int buyer_id,@RequestParam float amount) {
         if(walletAccountService.withdraw(buyer_id,amount)==1){
             BaseModel result = new BaseModel();
             result.code = 200;
             result.message = "withdraw success";
             return result;
         }else{
             throw BusinessException.UPDATE_FAIL;
         }
    }

    @PostMapping("/deposit")
    public BaseModel deposit(@RequestParam int buyer_id,@RequestParam float amount) {
        if(walletAccountService.deposit(buyer_id,amount)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "deposit success";
            return result;
        }else{
            throw BusinessException.UPDATE_FAIL;
        }
    }

    @PostMapping("/fund")
    public BaseModelJson<Float> fund(@RequestParam int buyer_id) {
        float fund = walletAccountService.fund(buyer_id);
        BaseModelJson<Float> result = new BaseModelJson<Float>();
        result.code = 200;
        result.message = "fetch success";
        result.data = fund;
        return result;
    }

    @PostMapping("/token")
    public int getIdFromToken(@RequestParam String token) {
        int id = TokenUtil.getId(token);
        return id;
    }
}
