package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CachingSystem {
    Map<Integer, Object> cache = new ConcurrentHashMap<>() {
    };
    private int counter = 0;
    private final int  CACHE_SIZE = 100;

    public synchronized void addCache(Object data){

        if(cache.size() == CACHE_SIZE){
            cache.remove(counter);
            --counter;
        }

        cache.put(counter++, data);

    }
    public Object getCacheData(int key){
        return cache.get(key);
    }

}
