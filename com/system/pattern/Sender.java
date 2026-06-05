package com.system.pattern;

public interface Sender{
    void attach(Receiver r);
    void detach(Receiver r);
    void notifyObservers();
}