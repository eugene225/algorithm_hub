import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        int len = times.length;
        
        long left = 1;
        long right = (long) times[len-1] * n;
        answer = right;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            
            for(int time : times) {
                total += (mid / time);
            }
            
            if(total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        return answer;
    }
}