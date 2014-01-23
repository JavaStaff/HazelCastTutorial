package com.javastaff.hazelcast.tutorial.store;

import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyStore implements MapLoader<String,String>, MapStore<String, String>{
    
    private static Properties properties;
    private static final String FILE_PROPERTIES = "data.properties";
    
    public MyStore() {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_PROPERTIES);
        try {
            properties.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(MyStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public String load(String k) {
        return properties.getProperty(k);
    }
    
    public Set<String> loadAllKeys() {
        System.out.println("MyStore.loadAllKeys ");
        Set keys = properties.keySet();
        return keys;
    }

    public Map<String,String> loadAll(Collection keys) {
        System.out.println("MyStore.loadAll keys " + keys);
        Map<String,String> map=new HashMap<String, String>();
        Iterator iterator=keys.iterator();
        String tempKey=null;
        while(iterator.hasNext()) {
            tempKey=(String)iterator.next();
            map.put(tempKey, properties.getProperty(tempKey));
        }
        return map;
    }

    public void storeAll(Map map) {
        System.out.println("MyStore.storeAll " + map.size());
    }

    public void deleteAll(Collection keys) {
        System.out.println("MyStore.deleteAll " + keys);
    }
    
    public void store(String k, String v) {
        System.out.println("MyStore.store - k:" +k+" v:"+v);
    }

    public void delete(String k) {
        System.out.println("MyStore.delete - k:" + k);
    }
    
}
