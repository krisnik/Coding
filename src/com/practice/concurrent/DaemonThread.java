package com.practice.concurrent;

/**
 * Created by Krishna Nikhil Vedurumudi on 12/09/16.
 */

class DaemonRunnable implements Runnable {
    public void run() {
        try {
            while (true) {
                System.out.println("Daemon is in progress");
                Thread.sleep(500);
            }
        } catch (InterruptedException ie) {
            System.out.println("Caught Interrupted Exception in Daemon RUnnable "+ie);
        }
    }
}
public class DaemonThread {

    public static void main(String args[]) {
        Thread daemon = new Thread(new DaemonRunnable());
        daemon.setDaemon(true);
        daemon.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            System.out.println("Caught Interrupted Exception in Daemon Main "+ie);
        }

        System.out.println("Exiting main..");
    }
}
