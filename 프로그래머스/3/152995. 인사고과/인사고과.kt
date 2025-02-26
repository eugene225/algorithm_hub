class Solution {
    fun solution(scores: Array<IntArray>): Int {
        val size = scores.size
        val n = scores[0][0]
        val m = scores[0][1]

        scores.sortWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })

        var maxScore = scores[0][1]

        for (i in 1 until size) {
            if (scores[i][1] < maxScore) {
                if (scores[i][0] == n && scores[i][1] == m) return -1

                scores[i][0] = -1
                scores[i][1] = -1
            } else {
                maxScore = scores[i][1]
            }
        }

        scores.sortByDescending { it.sum() }

        var rank = 1

        for (i in scores.indices) {
            if (scores[i].sum() > n + m) {
                rank++
            } else {
                break
            }
        }

        return rank
    }
}