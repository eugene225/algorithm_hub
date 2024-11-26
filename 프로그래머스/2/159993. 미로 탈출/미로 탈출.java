import java.util.*;

class Solution {
    private static char[][] map;
    private static boolean[][] visited;
    private static int N, M;

    public int solution(String[] maps) {
        N = maps.length; 
        M = maps[0].length();

        map = new char[N][M];
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int endX = 0, endY = 0;

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                map[j][i] = maps[j].charAt(i);
                if (map[j][i] == 'S') {
                    startX = j;
                    startY = i;
                } else if (map[j][i] == 'L') {
                    leverX = j;
                    leverY = i;
                } else if (map[j][i] == 'E') {
                    endX = j;
                    endY = i;
                }
            }
        }

        int route1 = bfs(startX, startY, leverX, leverY);
        int route2 = bfs(leverX, leverY, endX, endY);
        
        if (route1 == -1 || route2 == -1) return -1;
        return route1 + route2;
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private int bfs(int startX, int startY, int endX, int endY) {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int depth = current[2];

            if (x == endX && y == endY) {
                return depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, depth + 1});
                }
            }
        }
        return -1;
    }

    private boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
