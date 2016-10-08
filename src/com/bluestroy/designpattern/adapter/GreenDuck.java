package com.bluestroy.designpattern.adapter;

/**
 * Created by Troy on 2016/10/8.
 */
public class GreenDuck implements Duck {


    @Override
    public void quack() {
        System.out.println("Ga ga");
    }

    @Override
    public void fly() {
        System.out.println("long distance");
    }
}
