class Solution {
    private var ans: IntArray = IntArray(11) { 0 }
    private var maxDiff = 0
    private var lion: IntArray = IntArray(11) { 0 }

    fun solution(n: Int, info: IntArray): IntArray {
        maxDiff = 0
        lion = IntArray(11) { 0 }
        ans = IntArray(11) { 0 }
        dfs(0, n, info)
        return if (maxDiff == 0) intArrayOf(-1) else ans
    }

    private fun dfs(idx: Int, leftArrow: Int, info: IntArray) {
        if (idx == 11) {
            if (leftArrow > 0) {
                lion[10] += leftArrow
            }
            
            val (lionScore, apeachScore) = computeScores(info, lion)
            val diff = lionScore - apeachScore
            if (diff > 0) {
                if (diff > maxDiff || (diff == maxDiff && isBetter(lion, ans))) {
                    maxDiff = diff
                    ans = lion.copyOf()
                }
            }
            if (leftArrow > 0) {
                lion[10] -= leftArrow
            }
            return
        }

        if (leftArrow > info[idx]) {
            lion[idx] = info[idx] + 1
            dfs(idx + 1, leftArrow - lion[idx], info)
            lion[idx] = 0 
        }

        lion[idx] = 0
        dfs(idx + 1, leftArrow, info)
    }

    private fun computeScores(info: IntArray, lion: IntArray): Pair<Int, Int> {
        var lionScore = 0
        var apeachScore = 0
        for (i in 0 until 11) {
            if (info[i] == 0 && lion[i] == 0) continue
            if (lion[i] > info[i]) lionScore += (10 - i)
            else apeachScore += (10 - i)
        }
        return Pair(lionScore, apeachScore)
    }

    private fun isBetter(curr: IntArray, best: IntArray): Boolean {
        for (i in 10 downTo 0) {
            if (curr[i] != best[i]) {
                return curr[i] > best[i]
            }
        }
        return false
    }
}
