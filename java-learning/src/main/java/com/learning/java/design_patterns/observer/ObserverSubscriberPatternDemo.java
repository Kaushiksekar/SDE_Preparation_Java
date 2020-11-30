package com.learning.java.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

class Message{
    private String name;
    public Message(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

interface Subject{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyUpdate(Message message);
}

class MessagePublisher implements Subject{
    List<Observer> observers = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyUpdate(Message message) {
        for (Observer observer: observers)
            observer.update(message);
    }
}

interface Observer{
    void update(Message message);
}

class MessageSubscriberOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("Received by message subscriber 1 and message is : " + message.getName());
    }
}

class MessageSubscriberTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("Received by message subscriber 2 and message is : " + message.getName());
    }
}

class MessageSubscriberThree implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("Received by message subscriber 3 and message is : " + message.getName());
    }
}

public class ObserverSubscriberPatternDemo {

    public static void main(String[] args) {

        MessagePublisher messagePublisher = new MessagePublisher();
        MessageSubscriberOne messageSubscriberOne = new MessageSubscriberOne();
        MessageSubscriberTwo messageSubscriberTwo = new MessageSubscriberTwo();
        MessageSubscriberThree messageSubscriberThree = new MessageSubscriberThree();
        messagePublisher.attach(messageSubscriberOne);
        messagePublisher.attach(messageSubscriberTwo);
        messagePublisher.attach(messageSubscriberThree);

        messagePublisher.notifyUpdate(new Message("First Message"));

        messagePublisher.detach(messageSubscriberOne);
        messagePublisher.detach(messageSubscriberTwo);

        messagePublisher.notifyUpdate(new Message("Second Message"));


    }
}
