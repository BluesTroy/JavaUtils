package com.bluestroy.designpattern.factory;

import com.bluestroy.designpattern.factory.pizza.Pizza;

/**
 * 抽象工厂模式：将工厂方法族抽象出来一个抽象接口，所有的工厂方法具体实现。
 * 对外统一接口，不需要知道什么工厂。
 *
 * 总的：抽象出两层：工厂方法层，披萨层。
 * Created by Troy on 2016/10/8.
 */
public interface AbsFactory {
    public Pizza CreatePizza(String orderType);
    /**
     * LondonFactory/ NuYourkFactory
     */
}



/*
依赖抽象原则：
1、变量不要持有具体类的引用
2、不要让类继承自具体类，要继承自抽象类或接口
3、不要覆盖基类中已实现的方法（否则说明基类设计的不好）
 */


/**
 *
 * 简单工厂模式：定义了一个创建对象的类，由这个类来封装实例化对象的行为
 *
 * 工厂方法模式：定义了一个创建对象的抽象方法，由子类决定要实例化的类。
 * 工厂方法模式将对象的实例化推迟到子类
 *
 * 抽象工厂模式：定义了一个接口用于创建相关或有依赖关系的对象族，而无需明确指定具体类
 *
 *
 */

