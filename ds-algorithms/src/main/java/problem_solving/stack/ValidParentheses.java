package problem_solving.stack;

// 20 - https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    Map<Character, Character> map;
    Stack<Character> stack;

    {
        map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        stack = new Stack<>();
    }

    public boolean isValid(String s) {
        for (Character character: s.toCharArray()){
            if (character == '{' || character == '(' || character == '['){
                stack.push(character);
            }
            else{
                if (map.containsKey(character)){
                    if (stack.size() == 0)
                        return false;
                    if (stack.pop() == map.get(character))
                        continue;
                    else
                        return false;
                }
                else{
                    return false;
                }
            }
        }
        if (stack.size() > 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
        System.out.println(new ValidParentheses().isValid("([)]"));
    }
}
