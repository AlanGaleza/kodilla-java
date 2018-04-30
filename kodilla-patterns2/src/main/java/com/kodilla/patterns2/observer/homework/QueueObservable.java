package com.kodilla.patterns2.observer.homework;

public interface QueueObservable {
    void registerQueueObserver(QueueObserver queueObserver);
    void notifyObserver();
}
