package problem_solving.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseParenthesesAlternative {

    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == ')'){
                StringBuilder stringBuilder = new StringBuilder();
                while(stack.peek() != '('){
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
                for (int j=0; j<stringBuilder.length(); j++){
                    stack.push(stringBuilder.charAt(j));
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        while(stack.size() > 0){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(new ReverseParenthesesAlternative().reverseParentheses("(abcd)"));
//        System.out.println(new ReverseParenthesesAlternative().reverseParentheses("(u(love)i)"));
//        System.out.println(new ReverseParenthesesAlternative().reverseParentheses("(ed(et(oc))el)"));
        System.out.println(new ReverseParenthesesAlternative().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
