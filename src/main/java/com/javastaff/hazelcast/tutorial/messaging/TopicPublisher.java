package com.javastaff.hazelcast.tutorial.messaging;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TopicPublisher implements Runnable {

    private volatile boolean running;
    private HazelcastInstance hzInstance;
    private String[] cityList = {"Roma", "Milano", "Torino", "Napoli", "Palermo"};
    
    public TopicPublisher() {
        this.running = true;
        this.hzInstance = Hazelcast.newHazelcastInstance();
    }

    public static void main(String[] args) {
        TopicPublisher tp = new TopicPublisher();
        Thread thread = new Thread(tp);
        thread.start();
    }

    public void run() {
        do {
            publish();
            sleep();
        } while (running);
    }

    private void publish() {
        java.util.Random r=new Random();
        String posto=cityList[r.nextInt(cityList.length)];
        ITopic topic = hzInstance.getTopic("default");
        topic.publish("Allerta meteo per "+posto);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
