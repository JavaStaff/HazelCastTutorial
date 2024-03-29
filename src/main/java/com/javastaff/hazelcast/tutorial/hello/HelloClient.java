package com.javastaff.hazelcast.tutorial.hello;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import com.hazelcast.core.IMap;
public class HelloClient {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.addAddress("127.0.0.1:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("helloworld");
        System.out.println("Map Size:" + map.size());
        System.out.println(map.get(1)+" "+map.get(2));
        client.shutdown();
    }
}
