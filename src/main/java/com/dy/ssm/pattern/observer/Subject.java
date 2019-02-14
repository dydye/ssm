package com.dy.ssm.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class Subject {

    public List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){

        for (Observer observer : observers){
            observer.update();
        }

    }
}
