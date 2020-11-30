package problem_solving.hash_tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LRUCache {

    List<Integer> keys;
    List<Integer> values;
    Stack<Integer> lruKeyStack;
    Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keys = new ArrayList<>(capacity);
        this.values = new ArrayList<>(capacity);
        this.lruKeyStack = new Stack<>();
    }

    public int get(int key) {
        int index = keys.indexOf(key);
        if (index == -1){
            return -1;
        }
        int lruIndex = lruKeyStack.indexOf(key);
        lruKeyStack.remove(lruIndex);
        lruKeyStack.push(key);
        return values.get(index);
    }

    public void put(int key, int value) {
        if (keys.contains(key)){
            int index = keys.indexOf(key);
            values.set(index, value);
            int lruIndex = lruKeyStack.indexOf(key);
            lruKeyStack.remove(lruIndex);
            lruKeyStack.push(key);
            return;
        }
        if (keys.size() == capacity){
            int keyToBeRemoved = lruKeyStack.remove(0);
            int keyIndex = keys.indexOf(keyToBeRemoved);
            keys.remove(Integer.valueOf(keyToBeRemoved));
            values.remove(keyIndex);
        }
        keys.add(key);
        values.add(value);
        lruKeyStack.push(key);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
