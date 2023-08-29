import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);
 
        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);
        
        answer = Long.parseLong(sb.reverse().toString());
        
        return answer;
    }
}