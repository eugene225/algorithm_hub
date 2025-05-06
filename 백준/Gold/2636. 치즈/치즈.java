import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int beforeCount = 0;

        while (true) {
            int melted = bfs();
            if (melted == 0) {
                System.out.println(time);
                System.out.println(beforeCount);
                break;
            }
            beforeCount = melted;
            time++;
        }

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        int meltCount = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!isInBounds(nx, ny) || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0; // 녹임
                    meltCount++;
                } else {
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return meltCount;
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}