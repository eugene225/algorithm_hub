import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cnt1 = Integer.bitCount(n);
        
        for(int num=n+1;;num++) {
            int cnt2 = Integer.bitCount(num);
            if(cnt2 == cnt1) {
                answer = num;
                break;
            }
        }
        
        return answer;
    }
}