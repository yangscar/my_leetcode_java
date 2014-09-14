/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

import java.util.LinkedHashMap;
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    public LRUCache(final int capacity) {
        assert capacity > 0;
        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            //@overwrited
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) return -1;
        return value;
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}
