import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int cnt = 0;
        for(int i=0; i<citations.length; i++) {
            if(citations.length-i < cnt) break;
            while(citations[i] >= cnt && citations.length-i >= cnt) {
                answer = cnt++;
                //System.out.println("answer : " + answer + ", cnt : " + cnt + ", i : " + i);
            }
        }
        return answer;
    }
}