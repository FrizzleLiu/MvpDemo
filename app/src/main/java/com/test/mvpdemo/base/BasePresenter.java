package com.test.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * desc   : BasePresenter
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel, CONTRACT> {
    //M层
    protected M m;
    //V层  弱引用
    private WeakReference<V> vWeakReference;

    /**
     * @param v 绑定View层
     *          弱引用防止内存泄漏
     */
    public void bindView(V v) {
        vWeakReference = new WeakReference<>(v);
    }


    /**
     * @return 获取V层对象
     * 从弱引用中拿
     */
    public V getView() {
        if (vWeakReference != null) {
            return vWeakReference.get();
        }
        return null;
    }

    /**
     * 解绑View
     */
    public void unBindeView() {
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

    //获取子类的具体Contract 契约
    public abstract CONTRACT getContract();

    //获取子类的具体Model
    public abstract M getModel();
}
