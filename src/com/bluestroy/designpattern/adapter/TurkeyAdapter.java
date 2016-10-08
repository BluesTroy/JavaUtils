package com.bluestroy.designpattern.adapter;

/**
 * 对象适配器，将对象传入适配器
 * 对象适配器使用组合，类适配器使用继承
 * Created by Troy on 2016/10/8.
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 3; i++) {
            turkey.fly();
        }
    }
}


/*
适配器模式：
将一个类的接口转换成另一种接口，让原本接口不兼容的类可以兼容。

 */