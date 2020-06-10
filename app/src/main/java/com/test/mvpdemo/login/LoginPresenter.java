package com.test.mvpdemo.login;

import com.test.mvpdemo.LoginActivity;
import com.test.mvpdemo.base.BasePresenter;
import com.test.mvpdemo.bean.BaseBean;
import com.test.mvpdemo.bean.UserInfo;
import com.test.mvpdemo.engine.LoginEngine;

/**
 * desc   : LoginPresenter
 */
public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel, LoginContract.Presenter> {
    @Override
    public LoginContract.Presenter getContract() {
        //既要接收View层的指令
        //又要分配工作给Model层
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requestLogin(String account, String password) {
                try {
                    //1.P层可以不做事,只做转发,很多项目的写法都是这样的
                    getModel().getContract().executeLogin(account,password);

                    //2.P层处理,google的demo是这种方式
                    //具体业务逻辑实现,如登录请求等
//                    UserInfo userInfo = new UserInfo();
//                    userInfo.setName(account);
//                    userInfo.setPhone(password);
//                    getContract().responseResult(userInfo);

                    //3.交给功能模块去处理library,文件下载 图片下载,请求等
//                    LoginEngine<LoginPresenter> loginPresenterLoginEngine = new LoginEngine<>(LoginPresenter.this);
//                    loginPresenterLoginEngine.post(account, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(UserInfo baseBean) {
                getView().getContract().handleResult(baseBean);
            }
        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}
