package com.javastaff.hazelcast.tutorial.store;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import java.util.Map;

public class HazelCastServer {
    public static void main(String a[]) {
        Config myConfig = new Config();
        Map<String, MapConfig> myHazelcastMapConfigs = myConfig.getMapConfigs();
        MapConfig myMapConfig = new MapConfig();
        myMapConfig.setName("datiTraffico");
        myMapConfig.setTimeToLiveSeconds(1000);
        
        MyStore myStore=new MyStore();
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setEnabled(true);
        mapStoreConfig.setWriteDelaySeconds(0);
        mapStoreConfig.setImplementation(myStore);
        myMapConfig.setMapStoreConfig(mapStoreConfig);
        
        myHazelcastMapConfigs.put("datiTraffico", myMapConfig);
        Hazelcast.newHazelcastInstance(myConfig);
    }
}
