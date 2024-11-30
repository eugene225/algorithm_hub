import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if((sum1 + sum2) % 2 != 0) return -1;
        
        int N = queue1.length;
        int[] merge = new int[N*2];
        
        for(int i=0; i<N; i++) {
            merge[i] = queue1[i];
            merge[i+N] = queue2[i];
        }
        
        int l1 = 0; int r1 = N-1;
        int l2 = N; int r2 = N*2 - 1;
        
        long target = (sum1 + sum2) / 2;
        
        answer = 0;
        while(answer < 4*N) {
            if(sum1 < target) {
                r1 = (r1+1) % (N*2);
                l2 = (l2+1) % (N*2);
                
                sum1 += merge[r1];
                sum2 -= merge[r1];
                
                answer++;
            }
            if(sum2 < target) {
                r2 = (r2+1) % (N*2);
                l1 = (l1+1) % (N*2);
                
                sum2 += merge[r2];
                sum1 -= merge[r2];
                
                answer++;
            }
            
            if(sum1 == target && sum2 == target) {
                break;
            }
        }
        
        return sum1 == sum2 ? answer : -1;
    }
}