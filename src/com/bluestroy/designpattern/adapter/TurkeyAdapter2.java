package com.bluestroy.designpattern.adapter;

/**
 * 类适配器。调用超类的方法（没有对象适配器灵活，但代码稍简洁）
 * 继承被适配的类，实现要适配的接口
 * Created by Troy on 2016/10/8.
 */
public class TurkeyAdapter2 extends WildTurkey implements Duck {
    @Override
    public void quack() {

    }

    @Override
    public void fly() {
        super.fly();
        super.fly();
        super.fly();
    }
}
