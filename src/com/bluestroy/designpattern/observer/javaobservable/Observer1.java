package com.bluestroy.designpattern.observer.javaobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Troy on 2016/10/8.
 */
public class Observer1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("observer 2 do sth.");
    }
}
