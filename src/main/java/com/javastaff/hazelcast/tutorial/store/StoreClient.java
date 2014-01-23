package com.javastaff.hazelcast.tutorial.store;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class StoreClient {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.addAddress("127.0.0.1:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("datiTraffico");
        System.out.println("Map Size:" + map.size());
        System.out.println(map.get("key1")+" "+map.get("key2"));
        map.put("key1", "prova");
        map.remove("key2");
        client.shutdown();
    }
}
