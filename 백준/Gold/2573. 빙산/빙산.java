import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while(true) {
            int cnt = 0;
            visited = new boolean[N][M];
            int[][] zeroCount = new int[N][M];

            // 칸별로 0 count
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        zeroCount[i][j] = countZeros(i, j);
                    }
                }
            }

            // 빙산 녹이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        map[i][j] = Math.max(0, map[i][j] - zeroCount[i][j]);
                    }
                }
            }
            years++;

            // 빙산덩어리 수 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        cnt++;
                        if(cnt >= 2) {
                            System.out.println(years);
                            return;
                        }
                        dfs(new int[]{i, j});
                    }
                }
            }

            if(cnt == 0) {
                System.out.println(0);
                return;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void dfs(int[] now) {
        visited[now[0]][now[1]] = true;

        for(int i=0; i<4; i++) {
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];

            if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
                dfs(new int[]{nx, ny});
            }
        }
    }

    private static int countZeros(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isIn(nx, ny) && map[nx][ny] == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
