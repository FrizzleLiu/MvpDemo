package com.test.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.mvpdemo.base.BaseView;
import com.test.mvpdemo.bean.BaseBean;
import com.test.mvpdemo.bean.UserInfo;
import com.test.mvpdemo.login.LoginContract;
import com.test.mvpdemo.login.LoginPresenter;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> {

    private Button mBtnLogin;
    private EditText mEtAccount;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化控件
     * 点击事件
     */
    private void initView() {
        mBtnLogin = findViewById(R.id.btn_login);
        mEtAccount = findViewById(R.id.et_account);
        mEtPassword = findViewById(R.id.et_password);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }

    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handleResult(UserInfo userInfo) {
                if (userInfo != null) {
                    Toast.makeText(LoginActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败~", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    private void requestLogin() {
        String account = mEtAccount.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        p.getContract().requestLogin(account, password);
    }
}
