package com.bluestroy.designpattern.observer;

/**
 * Created by Troy on 2016/10/8.
 */
public class ObserverImpl2 implements Observer {
    @Override
    public void update() {
        System.out.println("Observer two do sth.");
    }
}
