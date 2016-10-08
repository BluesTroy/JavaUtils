package com.bluestroy.designpattern.observer.javaobservable;

import java.util.Observable;

/**
 * Java内置观察者
 * Created by Troy on 2016/10/8.
 */
public class SubjectImpl extends Observable {
    public void dataChange(){
        this.setChanged();  //表示数据有更新.使通知的时候更有灵活性
        this.notifyObservers(new Data());
    }

    public class Data{

    }
}

