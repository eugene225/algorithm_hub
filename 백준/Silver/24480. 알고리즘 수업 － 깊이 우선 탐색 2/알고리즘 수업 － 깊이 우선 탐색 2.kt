import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var visited: BooleanArray
private lateinit var rank: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M, R) = br.readLine().split(" ").map { it.toInt() }

    var map = Array(N+1) { mutableListOf<Int>() }
    visited = BooleanArray(N+1) { false }
    rank = IntArray(N+1) { 0 }

    repeat(M) {
        var (i, j) = br.readLine().split(" ").map { it.toInt() }
        map[i].add(j)
        map[j].add(i)
    }

    // println(map.contentToString())

    for(i in 1 .. N) {
        map[i].sortDescending()
    }

    dfs(R, map)

    for(i in 1 .. N) {
        println(rank[i])
    }
}

private var order: Int = 1

fun dfs(start: Int, map: Array<MutableList<Int>>) {
    visited[start] = true
    rank[start] = order++

    for(next in map[start]) {
        if(!visited[next]) {
            dfs(next, map)
        }
    }
}