package com.bluestroy.designpattern.observer;

/**
 * Created by Troy on 2016/10/8.
 */
public class Main {

    public static void main(String[] args){
        ObserverImpl1 observerImpl1 = new ObserverImpl1();
        ObserverImpl2 observerImpl2 = new ObserverImpl2();
        SubjectImpl subject = new SubjectImpl();

        subject.resigterObserver(observerImpl1);
        subject.resigterObserver(observerImpl2);

        subject.notifyObservers();
        System.out.println("--------------");
        subject.resigterObserver(observerImpl1);
        subject.notifyObservers();

    }
}
