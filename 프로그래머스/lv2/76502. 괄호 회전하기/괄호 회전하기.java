import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        String str = s+s;

        for(int i=0;i<s.length();i++){
            String s1 = str.substring(i, i+s.length());

            Stack<Character> stack = new Stack<>();

            boolean bool = true;
            for(int j=0;j<s1.length();j++){
                char ch = s1.charAt(j);
                if(ch=='(' || ch=='[' || ch=='{'){
                    stack.add(ch);
                }else if (ch==')' || ch=='}' || ch==']'){
                    if(stack.isEmpty()){
                        bool = false;
                        break;
                    }
                    char top = stack.peek();
                    if((ch==')' && top=='(') || (ch=='}' && top=='{') || (ch==']' && top=='[')){
                        stack.pop();
                    }else{
                        bool = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) bool = false;
            if(bool) answer++;
        }

        return answer;
    }
}