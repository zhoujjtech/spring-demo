package com.zhoujjtech.event;

import java.util.Observable;
import java.util.Observer;

public class AObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("AObserver...");
    }
}
