package com.test.mvpdemo.base;

/**
 * desc   : BaseModel
 *  接收Presenter层的业务处理请求
 *  第一个泛型是Presenter类型
 *  第二个泛型是Contract类型
 */
public abstract class BaseModel<P extends BasePresenter,CONTRACT> {
    //presenter引用
    //业务处理完毕,需要调用Contract(契约)中的接口中的方法 ->  void responseResult(T t)
    public P p;

    public BaseModel(P p) {
        this.p = p;
    }

    public abstract CONTRACT getContract();
}
