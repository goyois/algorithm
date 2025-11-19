import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()){
        try {
        if (c == '(') stack.push(c);
        else stack.pop();
            } catch (EmptyStackException e){
            answer = false;
            }
        }

        if (stack.size() > 0) answer = false;
        return answer;
    }
}