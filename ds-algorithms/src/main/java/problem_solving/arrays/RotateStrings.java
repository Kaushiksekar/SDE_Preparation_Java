package problem_solving.arrays;

// 796 - https://leetcode.com/problems/rotate-string/

public class RotateStrings {

    boolean rotateString(String A, String B) {
        if (A.equals(B))
            return true;
        for (int counter=0; counter < A.length(); counter++){
            if (A.equals(B)){
                return true;
            }
            A = A.substring(1) + A.charAt(0);
        }
        return false;
    }

    void rotateRightPractice(String A){
        for (int i=1; i<A.length(); i++){
            A = A.substring(0, i-1) + A.charAt(i) + A.charAt(i-1) + A.substring(i+1);
            System.out.println(A);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new RotateStrings().rotateString("abcde", "cdeab"));
//        System.out.println(new RotateStrings().rotateString("gcmbf", "fgcmb"));
        new RotateStrings().rotateRightPractice("abcde");
    }
}
