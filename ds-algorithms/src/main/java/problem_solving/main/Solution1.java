package problem_solving.main;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution1 {

    public static void main(String[] args) {
        List<List<String>> output = new Solution1().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(output);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String item: strs){
            String baseAnagram = getAnagramString(item);
            if (map.containsKey(baseAnagram)){
                map.get(baseAnagram).add(item);
            }
            else{
                map.put(baseAnagram, new ArrayList<String>(){{add(item);}});
            }
        }

        return new ArrayList<>(map.values());
    }

    public String getAnagramString(String item){
        char[] characterArray = item.toCharArray();
        Arrays.sort(characterArray);
        return new String(characterArray);
    }

}
