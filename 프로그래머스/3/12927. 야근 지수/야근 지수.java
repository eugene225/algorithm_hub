import java.util.*;

class Solution {
    public long solution(int n, int[] works) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  // 내림차순
        for (int work : works) {
            pq.offer(work);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            if(num > 0) {
                pq.offer(num-1);
                n--;
            }
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }
        
        return answer;
    }
}