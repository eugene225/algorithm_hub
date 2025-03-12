import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int moved = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int sum = bfs(i, j, union);

                        if (union.size() > 1) {
                            int avg = sum / union.size();
                            for (int[] pos : union) {
                                map[pos[0]][pos[1]] = avg;
                            }
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break;
            moved++;
        }

        System.out.println(moved);
    }

    private static int bfs(int x, int y, List<int[]> union) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0], cy = now[1];

            sum += map[cx][cy];
            union.add(now);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (checkNum(map[cx][cy], map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return sum;
    }

    private static boolean checkNum(int num1, int num2) {
        int cha = Math.abs(num1 - num2);
        return L <= cha && cha <= R;
    }
}
