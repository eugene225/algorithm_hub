import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";

        answer = dfs(p);

        return answer;
    }
    
    public static String dfs(String str) {

        // 입력된 문자열 빈 문자열이면 빈 문자열 반환
        if(str.length() == 0) {
            return "";
        }

        String u = "";
        String v = "";
        int lIdx = 0;
        int rIdx = 0;

        // 균형잡힌 괄호 문자열 u,v로 분리
        for(int i=0;i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                lIdx++;
            }else rIdx++;

            u += str.charAt(i);
            if(lIdx == rIdx) {
                v = str.substring(i+1);
                break;
            }
        }

        if(isCorrect(u)) {
            return u+=dfs(v);
        }
        else {
            String tmp = "(";
            tmp += dfs(v);
            tmp += ")";

            u = u.substring(1, u.length()-1);

            for(int i=0; i<u.length(); i++) {
                if(u.charAt(i) == '(') {
                    tmp += ')';
                } else {
                    tmp += '(';
                }
            }

            return tmp;
        }
    }


    //올바른 괄호 문자열 체크
    public static boolean isCorrect(String str) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                st.push('(');
            }else {
                if(st.isEmpty() || st.peek() == ')') {
                    return false;
                }else {
                    st.pop();
                }
            }
        }

        return true;
    }
}