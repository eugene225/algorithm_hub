import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int now = n;
        int chance = k;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<enemy.length;i++){
            pq.add(enemy[i]);

            if(pq.size() > chance){
                now -= pq.poll();
            }

            if(now < 0) {
                return i;
            }
        }

        return enemy.length;
    }
}