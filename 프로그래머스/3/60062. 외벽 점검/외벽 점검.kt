import kotlin.math.*

class Solution {
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        var answer = dist.size+1
        
        val len = weak.size
        val weakPoints = weak + weak.map { it + n }
        println(weakPoints.contentToString())
        
        for(start in 0 until len) {
            
            val permutations = permutation(dist)
            
            for(friend in permutations) {
                var cnt = 1
                var pos = weakPoints[start] + friend[0]
                
                for(i in start until start + len) {
                    if(weakPoints[i] > pos) {
                        cnt++
                        if(cnt > friend.size) break
                        pos = weakPoints[i] + friend[cnt-1]
                    }
                }
                
                answer = min(answer, cnt)
            }
        }
        
        return if (answer > dist.size) -1 else answer
    }
    
    private fun permutation(arr: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun generate(current: List<Int>, remaining: List<Int>) {
            if (remaining.isEmpty()) result.add(current)
            else {
                for (i in remaining.indices) {
                    generate(current + remaining[i], remaining.filterIndexed { index, _ -> index != i })
                }
            }
        }
        generate(emptyList(), arr.toList())
        return result
    }
}