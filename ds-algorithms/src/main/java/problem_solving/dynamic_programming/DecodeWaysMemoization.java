package problem_solving.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWaysMemoization {

    Map<Integer, Integer> map = new HashMap<>();

    private int numDecodings(int index, String s){

        if (s.length() == index)
            return 1;
        if (s.charAt(index) == '0')
            return 0;
        if (s.length() - 1 == index)
            return 1;

        if (map.containsKey(index))
            return map.get(index);

        int ans = numDecodings(index+1, s);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26)
            ans += numDecodings(index+2, s);

        map.put(index, ans);

        return ans;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        return numDecodings(0, s);
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWaysMemoization().numDecodings("12"));
        System.out.println(new DecodeWaysMemoization().numDecodings("226"));
        System.out.println(new DecodeWaysMemoization().numDecodings("0"));
        System.out.println(new DecodeWaysMemoization().numDecodings("1"));
        System.out.println(new DecodeWaysMemoization().numDecodings("10"));
        System.out.println(new DecodeWaysMemoization().numDecodings("27"));
    }
}
