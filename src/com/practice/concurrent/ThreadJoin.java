package com.practice.concurrent;

/**
 * Program ensures that t2 waits for completion of t1 and t3 waits for t2.
 */

class MyThread implements Runnable {

    String name;

    MyThread(String name ) {
        this.name = name;
    }
    public void run() {
        try {
            System.out.println("Starting thread  "+name);
            Thread.sleep(1000);
            System.out.println("Ending Thread "+name);
        }catch (InterruptedException ie) {
            System.out.println("Caught ie "+ie);
        }
    }

}
public class ThreadJoin {
    public static void main(String args[] ) {
        Thread t1 = new Thread(new MyThread("one"));
        Thread t2 = new Thread(new MyThread("two"));
        Thread t3 = new Thread(new MyThread("three"));
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException ie) {
            System.out.println("Caught ie in main "+ie);
        }

        System.out.println("Exiting main...");

    }
}
