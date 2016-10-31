package com.practice.concurrent;

/**
 * Created by Krishna Nikhil Vedurumudi on 08/08/16.
 */

class Counter {
    int value;

    public synchronized int incr() {
        value += 1;
        return value;
    }
}

class CounterThread extends Thread {
    Counter c;

    CounterThread(Counter c) {
        this.c = c;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("thread name "+this.getName()+" incr val "+c.incr());
        }
    }
}
public class SynchronizedExample {
    public static void main(String args[]) {
        Counter c = new Counter();

        CounterThread one = new CounterThread(c);
        CounterThread two = new CounterThread(c);

        one.start();
        two.start();
    }
}
