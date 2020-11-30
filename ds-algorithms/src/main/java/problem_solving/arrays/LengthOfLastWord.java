package problem_solving.arrays;

// 58 - https://leetcode.com/problems/length-of-last-word/

public class LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));

    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i=s.length()-1; i>= 0; i--){
            if (s.charAt(i) != ' '){
                count++;
            }
            else if (s.charAt(i) == ' ' && count > 0){
                break;
            }
        }
        return count;
    }

}
