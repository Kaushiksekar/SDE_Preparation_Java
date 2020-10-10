package com.learning.java.concurrency.basic_threading;

public class ThreadSafeByImmutability {

    public static void main(String[] args) {

        // thread safe when using immutable values
        ImmutableValue immutableValue = new ImmutableValue(6);
        new Thread(() -> System.out.println(immutableValue.add(5).getValue())).start();
        new Thread(() -> System.out.println(immutableValue.add(4).getValue())).start();

        // not thread safe when using mutable representation of immutable values
        Calculator calculator = new Calculator(){{setImmutableValue(new ImmutableValue(7));}};
        new Thread(() -> {
            calculator.add(5);
            System.out.println(calculator.getImmutableValue().getValue());
        }).start();
        new Thread(() -> {
            calculator.add(7);
            System.out.println(calculator.getImmutableValue().getValue());
        }).start();

    }

}

class Calculator{

    private ImmutableValue immutableValue;

    public ImmutableValue getImmutableValue() {
        return immutableValue;
    }

    public void setImmutableValue(ImmutableValue immutableValue) {
        this.immutableValue = immutableValue;
    }

    public void add(int newValue){
        this.immutableValue = immutableValue.add(newValue);
    }

}

class ImmutableValue{

    // value is gotten through constructor and never changed. hence it is immutable
    private int value = 0;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // add does not simply add to existing value. it adds and crates a new object and then returns that
    // maintaining immutability

    // if 'this' is returned, this object will not be threadsafe
    public ImmutableValue add(int valueToAdd){
//        value += valueToAdd;
//        return this;
        return new ImmutableValue(value + valueToAdd);
    }

}
