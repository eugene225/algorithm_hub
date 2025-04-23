import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Edge> edgeList = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islandId++);
                }
            }
        }

        // 2. 다리 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 1)
                    findBridges(i, j, map[i][j]);
            }
        }

        // 3. MST
        int islandCount = islandId - 2;
        parent = new int[islandId];
        for (int i = 0; i < islandId; i++) parent[i] = i;

        Collections.sort(edgeList);
        int result = 0, count = 0;
        for (Edge e : edgeList) {
            if (union(e.start, e.end)) {
                result += e.cost;
                count++;
            }
        }

        System.out.println(count == islandCount - 1 ? result : -1);

    }

    static void bfs(int x, int y, int islandId) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandId;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = islandId;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void findBridges(int x, int y, int islandId) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            int len = 0;
            while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == islandId) break;
                if (map[nx][ny] > 0) {
                    if (len >= 2) {
                        edgeList.add(new Edge(islandId, map[nx][ny], len));
                    }
                    break;
                }
                len++;
                nx += dx[d];
                ny += dy[d];
            }
        }
    }

    static int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false; // root가 동일하면 같은집합
        parent[b] = a; // 다른 집합이면 합침
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}