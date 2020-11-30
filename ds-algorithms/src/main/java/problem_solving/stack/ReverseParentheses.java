package problem_solving.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 1190 - This implementation only works if all strings have ( at start and ) at end

public class ReverseParentheses {

    public String reverseParentheses(String s) {
        if (s.length() <= 1){
            return s;
        }
        List<Stack<Character>> listOfStacks = new ArrayList<>();
        Stack<Character> stack = null;
        StringBuilder latestString = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack = new Stack<>();
                listOfStacks.add(stack);
                latestString = new StringBuilder();
            }
            else if(s.charAt(i) == ')'){
                latestString = new StringBuilder();
                while(stack.size() > 0){
                    latestString.append(stack.pop());
                }
                if (listOfStacks.size() > 1){
                    listOfStacks.remove(listOfStacks.size()-1);
                    for (int j=0; j<latestString.length(); j++){
                        stack = listOfStacks.get(listOfStacks.size()-1);
                        stack.push(latestString.charAt(j));
                    }
                }
                else{
                    listOfStacks.remove(listOfStacks.size()-1);
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        return latestString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseParentheses().reverseParentheses("(abcd)"));
        System.out.println(new ReverseParentheses().reverseParentheses("(u(love)i)"));
        System.out.println(new ReverseParentheses().reverseParentheses("(ed(et(oc))el)"));
    }

}
