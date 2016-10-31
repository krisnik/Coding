package com.practice.concurrent;

/**
 * Created by Krishna Nikhil Vedurumudi on 08/08/16.
 */

class Exchanger {
    private String data = "";
    private boolean hasData = false;

    void setData(String data) {
        hasData = true;
        this.data = data;
    }

    boolean getHasData() {
        return this.hasData;
    }

    String getData() {
        hasData = false;
        return this.data;
    }
}

class Producer extends Thread {

    private Exchanger e;

    Producer(Exchanger e) {
        this.e = e;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                produce(i);
            }
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void produce(int count) throws InterruptedException{
        synchronized (e) {
            if(e.getHasData()){
                e.wait();
            }
        }

        synchronized (e) {
            System.out.println("Produced Hello "+count);
            e.setData("Hello "+count);
            e.notify();
        }
    }
}

class Consumer extends Thread {

    private Exchanger e;

    Consumer(Exchanger e) {
        this.e = e;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                consume();
            }
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void consume() throws InterruptedException{
        synchronized (e) {
            if(!e.getHasData()){
                e.wait();
            }
        }

        synchronized (e) {
            System.out.println("Consumed "+e.getData());
            e.notify();
        }
    }

}

public class ProducerConsumer {
    public static void main(String args[]) {

        Exchanger e = new Exchanger();

        Producer prod = new Producer(e);
        Consumer cons = new Consumer(e);

        prod.start();
        cons.start();

    }
}


