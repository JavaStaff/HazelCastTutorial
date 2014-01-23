package com.javastaff.hazelcast.tutorial.messaging;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class TopicSubscriber implements MessageListener<String>{
    
    public TopicSubscriber() {
        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
        ITopic<String> topic = hzInstance.getTopic("default");
        topic.addMessageListener(this);
    }
    
    public void onMessage(Message<String> msg) {
        System.out.println(msg.getPublishTime()+" - "+msg.getMessageObject());
    }
    
    public static void main(String a[]) {
        new TopicSubscriber();
    }
    
}
