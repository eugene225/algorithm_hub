import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*
import kotlin.collections.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val matrix = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val houses = mutableListOf<Pair<Int, Int>>()
    val chickens = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until N) {
        for (j in 0 until N) {
            when (matrix[i][j]) {
                1 -> houses.add(i to j)
                2 -> chickens.add(i to j)
            }
        }
    }

    var minDistance = Int.MAX_VALUE

    // M개의 치킨집 선택하는 모든 조합 탐색
    for (selected in chickens.combinations(M)) {
        val cityChickenDistance = houses.sumOf { house ->
            selected.minOf { chicken -> calculateDis(house, chicken) }
        }
        minDistance = min(minDistance, cityChickenDistance)
    }

    println(minDistance)
}

private fun calculateDis(dot1: Pair<Int, Int>, dot2: Pair<Int, Int>): Int {
    return abs(dot1.first - dot2.first) + abs(dot1.second - dot2.second)
}

fun <T> List<T>.combinations(k: Int): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val combination = mutableListOf<T>()

    fun backtrack(start: Int) {
        if (combination.size == k) {
            result.add(ArrayList(combination))
            return
        }
        for (i in start until this.size) {
            combination.add(this[i])
            backtrack(i + 1)
            combination.removeAt(combination.size - 1)
        }
    }

    backtrack(0)
    return result
}