package com.bluestroy.designpattern.factory.pizza;

/**
 * Created by Troy on 2016/10/8.
 */
public class PepperPizza extends Pizza {

    @Override
    public void prepare() {
        super.setName("PepperPizza");
        System.out.println(name+ " preparing");
    }
}
