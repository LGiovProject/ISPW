package com.ispw.circularbook.engineering.observer;

import java.util.List;

public abstract class Subject {

    public abstract void register(Observer o);
    public abstract void register(List<Observer> observers);
    public abstract void unregister(Observer o);
    public abstract void notifyObserver(Object object);
    public abstract void notifyObserver(Object object1, Object object2);
}
