package problem_solving.hash_tables;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    List<Integer> keys;
    List<Integer> values;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (keys.contains(key)){
            int index = keys.indexOf(key);
            values.set(index, value);
            return;
        }
        keys.add(key);
        values.add(value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = keys.indexOf(key);
        if (index == -1){
            return -1;
        }
        return values.get(index);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int keyIndex = keys.indexOf(key);
        if (keyIndex != -1){
            keys.remove(keyIndex);
            values.remove(keyIndex);
        }
    }
}

public class DesignHashMap {

    public static void main(String[] args) {

    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 10);
        System.out.println(myHashMap.get(1));

    }

}
