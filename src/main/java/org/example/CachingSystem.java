package org.example;

import java.util.HashMap;
import java.util.Map;

public class CachingSystem {
    Map<Integer, Object> cache = new HashMap<>();
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
