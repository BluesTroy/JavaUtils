package com.bluestroy.designpattern.observer;

import java.util.ArrayList;

/**
 * Created by Troy on 2016/10/8.
 */
public class SubjectImpl implements Subject {

    private ArrayList<Observer> mObservers;

    public SubjectImpl() {
        this.mObservers = new ArrayList<Observer>();
    }

    @Override
    public void resigterObserver(Observer o) {
        mObservers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        if (mObservers.contains(o)){
            mObservers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        //分推模式和拉模式：
        /**
         * 如果要传递给观察者的参数多、复杂、数据量大，则只是通知，让观察者自己取数据。
         * 简单的话可以直接传参数
         * 本例中没有出传递参数。
         */
        for (Observer observer: mObservers) {
            observer.update();
        }
    }
}
