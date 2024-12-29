import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        char[] charAr = name.toCharArray();
        int len = charAr.length;
        int end = charAr.length - 1;
        
        for(int i=0; i<len; i++) {
            char ch = charAr[i];
            
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            answer += Math.min(Math.abs((int) ch - 'A'), 26 - Math.abs((int) ch - 'A'));
            end = Math.min(end, i + len - next + Math.min(i, len - next));
        }
        
        return answer + end;
    }
}