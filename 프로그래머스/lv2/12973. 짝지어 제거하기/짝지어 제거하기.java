import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        char[] ar = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<ar.length;i++) {
            char ch = ar[i];
            
            if(stack.isEmpty()) stack.push(ch);
            else {
                if(stack.peek() == ch) stack.pop();
                else {
                    stack.push(ch);
                }
            }
        }

        answer = stack.isEmpty() ? 1 : 0;
        
        return answer;
    }
}