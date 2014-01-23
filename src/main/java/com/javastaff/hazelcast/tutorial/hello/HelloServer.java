package com.javastaff.hazelcast.tutorial.hello;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.Map;

public class HelloServer {
    public static void main( String[] args ) {
        Config cfg = new Config();
        NetworkConfig network = cfg.getNetworkConfig();
        network.setPort(5701);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
        Map<Integer, String> map = instance.getMap("helloworld");
        map.put(1, "Hello");
        map.put(2, "World");
    }
}
