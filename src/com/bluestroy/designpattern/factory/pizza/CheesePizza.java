package com.bluestroy.designpattern.factory.pizza;

/**
 * Created by Troy on 2016/10/8.
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        super.setName("CheesePizza");
        System.out.println(name + " preparing");
    }
}
