import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        if(s.charAt(0) == ')') return false;
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                stack.push(ch);
            }else if(ch == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        if(stack.size() > 0) {
            answer = false;
        }

        return answer;
    }
}