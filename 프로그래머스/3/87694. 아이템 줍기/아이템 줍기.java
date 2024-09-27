import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1}; 
    private int[][] rectangles;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.rectangles = rectangle;
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private boolean isOnBorder(int x, int y) {
        for (int[] rec : rectangles) {
            int x1 = rec[0] * 2, y1 = rec[1] * 2;
            int x2 = rec[2] * 2, y2 = rec[3] * 2;

            boolean onXBorder = (x == x1 || x == x2) && y >= y1 && y <= y2;
            boolean onYBorder = (y == y1 || y == y2) && x >= x1 && x <= x2;

            if (onXBorder || onYBorder) {
                return true;
            }
        }
        return false;
    }

    private boolean isInsideRectangle(int x, int y) {
        for (int[] rec : rectangles) {
            int x1 = rec[0] * 2, y1 = rec[1] * 2;
            int x2 = rec[2] * 2, y2 = rec[3] * 2;
            if (x > x1 && x < x2 && y > y1 && y < y2) {
                return true;
            }
        }
        return false;
    }

    private int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];

        q.offer(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], dist = now[2];

            if (x == itemX && y == itemY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx <= 200 && ny >= 0 && ny <= 200 && !visited[nx][ny]) {
                    // 내부가 아니고, 경계선에 있는 경우만 이동
                    if (!isInsideRectangle(nx, ny) && isOnBorder(nx, ny)) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return 0;
    }
}
