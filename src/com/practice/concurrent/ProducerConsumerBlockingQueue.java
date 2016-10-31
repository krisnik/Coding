package com.practice.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Krishna Nikhil Vedurumudi on 12/09/16.
 */
class ProducerBQ implements Runnable{
    BlockingQueue<String> messages;

    ProducerBQ(BlockingQueue<String> messages) {
        this.messages = messages;
    }

    public void run() {
        for(int i =0; i< 10; i++) {
            String message = "Hello "+i;
            System.out.println("Produced "+message);
            try {
                messages.put(message);
            } catch (InterruptedException ie) {
                System.out.println("Caught InterruptedException in Producer "+ie);
            }
        }
    }

}

class ConsumerBQ implements Runnable{
    BlockingQueue<String> messages;

    ConsumerBQ(BlockingQueue<String> messages) {
        this.messages = messages;
    }

    public void run() {
        for(int i =0; i< 10; i++) {
            try {
                String message = messages.take();
                System.out.println("Consumed "+message);
            } catch (InterruptedException ie) {
                System.out.println("Caught InterruptedException in Consumer "+ie);
            }
        }
    }
}
public class ProducerConsumerBlockingQueue {
    public static void main(String args[]) {

        BlockingQueue<String> messages = new LinkedBlockingQueue<>();
        Thread producer = new Thread(new ProducerBQ(messages));
        Thread consumer = new Thread(new ConsumerBQ(messages));

        consumer.start();
        producer.start();
    }
}
