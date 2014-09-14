public class LRUCache {
    class CacheNode{
        int key;
        int value;
        CacheNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<CacheNode> cacheList;
    HashMap<Integer, CacheNode> cacheMap;
    int capacity;
    
    public LRUCache(int capacity) {
        cacheMap = new HashMap<Integer, CacheNode>();
        cacheList = new LinkedList<CacheNode>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;
        CacheNode oldNode = cacheMap.get(key);
        cacheList.remove(oldNode);
        cacheList.offerFirst(oldNode);
        return oldNode.value;
    }
    
    public void set(int key, int value) {
        if (!cacheMap.containsKey(key)){
            if (cacheList.size() == capacity){
                CacheNode last = cacheList.removeLast();
                cacheMap.remove(last.key);
            }
            CacheNode node = new CacheNode(key,value);
            cacheList.offerFirst(node);
            cacheMap.put(key,node);
        } else {
            CacheNode oldNode = cacheMap.get(key);
            cacheList.remove(oldNode);
            oldNode.value = value;
            cacheList.offerFirst(oldNode);
        }
    }
}
