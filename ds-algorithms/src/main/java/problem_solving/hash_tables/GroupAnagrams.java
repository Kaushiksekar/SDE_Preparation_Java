package problem_solving.hash_tables;

//49

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String item: strs){
            String baseAnagram = getBaseAnagram(item);
            if (map.containsKey(baseAnagram)){
                map.get(baseAnagram).add(item);
            }
            else{
                map.put(baseAnagram, new ArrayList<>() {{add(item);}});
            }
        }
        return new ArrayList<>(map.values());
    }

    private String getBaseAnagram(String string){
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {

        new GroupAnagrams().groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}).stream().forEach(strings -> {
            for (String item: strings){
                System.out.print(item + " ");
            }
            System.out.println();
        });

    }
}
