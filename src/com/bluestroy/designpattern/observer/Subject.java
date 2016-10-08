package com.bluestroy.designpattern.observer;

/**
 * Created by Troy on 2016/10/8.
 */
public interface Subject {

    public void resigterObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
