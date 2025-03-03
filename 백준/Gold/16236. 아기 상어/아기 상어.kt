import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var start = intArrayOf(0, 0)
    val map = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        map[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] == 9) {
                start = intArrayOf(i, j)
                map[i][j] = 0
            }
        }
    }

    var size = 2
    var eaten = 0
    var time = 0

    val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

    fun bfs(x: Int, y: Int): Triple<Int, Int, Int>? {
        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b ->
            when {
                a.first != b.first -> a.first - b.first  // 거리 기준 정렬
                a.second != b.second -> a.second - b.second  // y 좌표 기준 정렬
                else -> a.third - b.third  // x 좌표 기준 정렬
            }
        }
        val visit = Array(N) { BooleanArray(N) }
        pq.add(Triple(0, x, y))
        visit[x][y] = true

        while (pq.isNotEmpty()) {
            val (dist, cx, cy) = pq.poll()
            if (map[cx][cy] in 1 until size) return Triple(dist, cx, cy)

            for (dir in directions) {
                val nx = cx + dir[0]
                val ny = cy + dir[1]
                if (nx in 0 until N && ny in 0 until N && !visit[nx][ny] && map[nx][ny] <= size) {
                    visit[nx][ny] = true
                    pq.add(Triple(dist + 1, nx, ny))
                }
            }
        }
        return null
    }

    while (true) {
        val result = bfs(start[0], start[1]) ?: break
        val (dist, nx, ny) = result

        time += dist
        eaten++
        start[0] = nx
        start[1] = ny
        map[nx][ny] = 0

        if (eaten == size) {
            size++
            eaten = 0
        }
    }

    println(time)
}