package com.test.mvpdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * desc   : BaseView
 * View层的基类 mvp中Activity是View层
 */
public abstract class BaseView<P extends BasePresenter,CONTRACT> extends AppCompatActivity {
    public P p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p=getPresenter();
        //P层绑定View层,采用弱引用的方式,防止内存泄漏
        p.bindView(this);
    }

    //需要P层做什么业务
    //从子类中获取具体Contract契约
    public abstract CONTRACT getContract();

    //从子类中获取具体Presenter
    public abstract P getPresenter();

    //如果Presenter层出现异常,需要告诉View层
    public void error(Exception e){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //P层解绑View层
        p.unBindeView();
    }
}
