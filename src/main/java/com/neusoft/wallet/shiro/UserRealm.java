package com.neusoft.wallet.shiro;

import com.neusoft.wallet.wallet.entity.WalletAccount;
import com.neusoft.wallet.wallet.service.WalletAccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    WalletAccountService walletAccountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("waa:waalist");
        Subject subject = SecurityUtils.getSubject();
        WalletAccount waa = (WalletAccount) subject.getPrincipal();
        info.addStringPermission(waa.getAccount_type()+"");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String accountname = (String) authenticationToken.getPrincipal();
        WalletAccount waa = walletAccountService.getByName(accountname);
        if(waa != null){
            return new SimpleAuthenticationInfo(waa,waa.getPassword(),waa.getAccount_name());
        }else{
            return null; //UnknownAccountException
        }

    }
}
