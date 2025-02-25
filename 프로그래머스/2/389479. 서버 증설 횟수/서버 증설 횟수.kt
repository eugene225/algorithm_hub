import java.util.*;

class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0
        
        var pq = PriorityQueue<Array<Int>>(compareBy { it[0] });
        var size = 0
        var cnt = 0
        
        for(time in 0 until 24) {
            while(!pq.isEmpty() && pq.peek()[0] == time) {
                size -= pq.poll()[1]
            }
            var need = players.get(time) / m
            var add = need - size
            if(add > 0) {
                size += add
                cnt += add
                
                pq.add(arrayOf(time+k, add))
            }
        }
        
        return cnt
    }
}