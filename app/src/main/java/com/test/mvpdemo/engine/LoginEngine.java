package com.test.mvpdemo.engine;

import com.test.mvpdemo.bean.UserInfo;
import com.test.mvpdemo.login.LoginPresenter;

/**
 * desc   : LoginEngine
 */
public class LoginEngine<P extends LoginPresenter> {
    private P p;

    public LoginEngine(P p) {
        this.p = p;
    }

    public void post(String account,String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(account);
        userInfo.setPhone(password);
        p.getContract().responseResult(userInfo);
    }
}
