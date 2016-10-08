package com.bluestroy.designpattern.adapter;

/**
 * Created by Troy on 2016/10/8.
 */
public class WildTurkey implements Turkey{


    @Override
    public void gobble() {
        System.out.println("go go");
    }

    @Override
    public void fly() {
        System.out.println("short distance ");
    }
}
