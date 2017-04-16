package com.github.obsessive.tests.sheji_moshhi;

/**
 * Created by liuguodong on 2017/4/13.
 */

public class Singleton {
    private volatile static Singleton singleton = null;

    private Singleton() {
    }


    public static Singleton getSingleton() {
        //先检查实例是否存在，如果不存在进入下面代码块
        if (singleton == null) {
            //同步块，线程安全的创建实例
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
