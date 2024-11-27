import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        Stack<Character> answer = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            char cur = number.charAt(i);
            while(!answer.isEmpty() && answer.peek() < cur && k-- > 0) {
                answer.pop();
            }
            answer.push(cur);
        }
        
        StringBuilder result = new StringBuilder();
        while (!answer.isEmpty()) {
            result.append(answer.pop());
        }
        
        if (k > 0) {
            return result.reverse().toString().substring(0, result.toString().length() - k);
        }
        
        return result.reverse().toString();
    }
}