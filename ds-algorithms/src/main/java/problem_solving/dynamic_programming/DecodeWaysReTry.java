package problem_solving.dynamic_programming;

// 91 - https://leetcode.com/problems/decode-ways/

import java.util.ArrayList;
import java.util.List;

public class DecodeWaysReTry {

    public static void main(String[] args) {
//        System.out.println(new DecodeWaysReTry().numDecodings("12"));
        System.out.println(new DecodeWaysReTry().numDecodings("226"));
//        System.out.println(new DecodeWaysReTry().numDecodings("0"));
//        System.out.println(new DecodeWaysReTry().numDecodings("1"));
//        System.out.println(new DecodeWaysReTry().numDecodings("10"));
//        System.out.println(new DecodeWaysReTry().numDecodings("27"));
    }

    public String getValue(String character){
        int ascii = Integer.parseInt(character) + 64;
        if (ascii < 65 || ascii > 90)
            return null;
        return Character.toString((char) ascii);
    }

    public int numDecodings(String string) {
        List<List<String>> result = new ArrayList<>();
        String previous = "";
        boolean flag;

        for (int outerIndex=0; outerIndex<string.length(); outerIndex++){
            flag = false;
            if (outerIndex == 0){
                String value = getValue(String.valueOf(string.charAt(outerIndex)));
                if (value != null) {
                    List<String> list = new ArrayList<>();
                    list.add(value);
                    result.add(list);
                }
                previous = String.valueOf(string.charAt(outerIndex));
                continue;
            }
            for (int listIndex=0; listIndex<result.size(); listIndex++) {
                String value = getValue(String.valueOf(string.charAt(outerIndex)));
                if (value != null) {
                    result.get(listIndex).add(value);
                }
                else{
                    List<String> list = result.get(listIndex);
                    list.set(list.size()-1, getValue(string.charAt(outerIndex) + previous));
                    flag = true;
                }
            }
            if (!flag){
                String value = getValue(string.charAt(outerIndex) + previous);
//            result.get(result.size()-1).add(value);
                if (value != null) {
                    List<String> list = new ArrayList<>();
                    list.add(value);
                    result.add(list);
                }
            }
            previous = String.valueOf(string.charAt(outerIndex));
        }
        return result.size();
    }
}
