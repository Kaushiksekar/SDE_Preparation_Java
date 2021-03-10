package problem_solving.dynamic_programming;

// 392 - This could easily solved with two pointers or using set, but here, I'm trying to learn dynamic programming

import java.util.Arrays;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int sIndex=1; sIndex<=s.length(); sIndex++){
            for (int tIndex=1; tIndex<=t.length(); tIndex++){
                if (s.charAt(sIndex-1) == t.charAt(tIndex-1)){
                    dp[sIndex][tIndex] = dp[sIndex-1][tIndex-1] + 1;
                }
                else{
                    dp[sIndex][tIndex] = Math.max(dp[sIndex-1][tIndex], dp[sIndex][tIndex-1]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
//        System.out.println(dp[s.length()][t.length()]);
//        System.out.println(t.length());
        return dp[s.length()][t.length()] == s.length();
    }

    public static void main(String[] args) {
//        System.out.println(new IsSubsequence().isSubsequence("ace", "abcde"));
//        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("bb", "ahbgdc"));
    }
}
