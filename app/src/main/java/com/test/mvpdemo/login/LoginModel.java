package com.test.mvpdemo.login;

import com.test.mvpdemo.base.BaseModel;
import com.test.mvpdemo.bean.UserInfo;

/**
 * desc   : LoginModel
 * 接收P层需要做的业务
 */
public class LoginModel extends BaseModel<LoginPresenter,LoginContract.Model> {

    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String account, String password) throws Exception {
                //具体业务逻辑实现,如登录请求等
                UserInfo userInfo = new UserInfo();
                userInfo.setName(account);
                userInfo.setPhone(password);
                p.getContract().responseResult(userInfo);
            }
        };
    }
}
