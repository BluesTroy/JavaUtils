package com.bluestroy.designpattern.adapter;

/**
 * Created by Troy on 2016/10/8.
 */
public class MainTest {
    public static void main(String[] args) {
        GreenDuck duck = new GreenDuck();
        WildTurkey turkey = new WildTurkey();
        TurkeyAdapter adapterTurkey = new TurkeyAdapter(turkey);
        duck.quack();
        duck.fly();
        System.out.println("-------");
        turkey.gobble();
        turkey.fly();
        System.out.println("-------");
        adapterTurkey.quack();
        adapterTurkey.fly();

        System.out.println("-------");
        Duck duck2 = new TurkeyAdapter2();
        duck2.quack();
        duck2.fly();


    }
}
