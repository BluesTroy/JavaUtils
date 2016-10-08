package com.bluestroy.designpattern.factory;

import com.bluestroy.designpattern.factory.pizza.CheesePizza;
import com.bluestroy.designpattern.factory.pizza.PepperPizza;
import com.bluestroy.designpattern.factory.pizza.Pizza;

/**
 * 简单工厂模式，就是简单地把变化的部分（创建不同实例的部分）抽离出来。
 *
 * 工厂方法模式：（工厂方法族）
 * 进一步的工厂方法模式——是在OrderPizza中不是直接使用简单工厂，而是把创建Pizza的方法变成抽象方法，
 * 然后在不同的工厂中具体实现创建Pizza的细节，比如伦敦披萨工厂，纽约披萨工程。
 *
 *
 * Created by Troy on 2016/10/8.
 */
public class SimplePizzaFactory {

    public Pizza CreatePizza(String orderType){
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new CheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new PepperPizza();
        }
        return pizza;
    }
}
