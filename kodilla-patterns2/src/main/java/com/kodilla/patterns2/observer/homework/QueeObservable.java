package com.kodilla.patterns2.observer.homework;

public interface QueeObservable {
    void registerQueeObserver(QueeObserver queeObserver);
    void notifyObserver();
}
