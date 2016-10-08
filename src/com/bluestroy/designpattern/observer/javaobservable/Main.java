package com.bluestroy.designpattern.observer.javaobservable;

/**
 * Created by Troy on 2016/10/8.
 */
public class Main {
    public static void main(String[] args) {
        //Java内置观察者
        //
        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();

        SubjectImpl subject = new SubjectImpl();
        subject.addObserver(o1);
        subject.addObserver(o2);
        subject.dataChange();
        System.out.println("_________");
        subject.deleteObserver(o2);
        subject.dataChange();
    }

}
