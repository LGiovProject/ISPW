package com.ispw.circularbook.engineering.observer;

public interface Observer {

     void update(Object element);

     void update(Object bean, Object element);
}
