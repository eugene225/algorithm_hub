import java.util.*;

class Solution {
    public long solution(int[] diffs, int[] times, long limit) {        
        return binarySearch(diffs, times, limit);
    }
    
    private int binarySearch(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;
        
        while(left < right) {
            long mid = (left + right) / 2;
            if(canSolve(diffs, times, limit, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) left;
    }
    
    private boolean canSolve(int[] diffs, int[] times, long limit, long level) {
        long ans = (long)times[0];
        for(int i=1; i<diffs.length; i++) {
            long diff = (long)diffs[i];
            long time_cur = (long)times[i];
            
            if(diff <= level) {
                ans += time_cur;
            } else {
                ans += ((long)times[i-1] + time_cur) * (diff - level) + time_cur;
            }
        }
        
        if(ans <= limit) return true;
        else return false;
    }
}