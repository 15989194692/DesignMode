package com.lsz.observer.demo;

import com.lsz.observer.api.Observer;
import com.lsz.observer.api.Subject;

import java.util.ArrayList;
import java.util.List;

public class MySubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
