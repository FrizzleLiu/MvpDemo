package com.test.mvpdemo.login;

import com.test.mvpdemo.bean.BaseBean;

/**
 * desc   : LoginContract
 * 登录业务的契约类
 * 将Model层 View层 Presenter层协商的共同业务,封装成接口
 */
public interface LoginContract {
    interface Model {
        //Model层完成具体业务的接口  BaseModel子类完成具体实现
     void executeLogin(String account,String password) throws Exception;
    }

    interface View<T extends BaseBean>{
        //用泛型就不需要强转了,泛型的好处
        //项目中一般是json解析的javabean
        void handleResult(T t);
    }

    interface Presenter<T extends BaseBean> {
        //1.接收到View层的登录指令,可以自己处理,也可以交给 Model层处理
        void requestLogin(String account,String password);

        //2.接收到Model层处理结果,通知View层刷新
        void responseResult(T t);
    }
}
