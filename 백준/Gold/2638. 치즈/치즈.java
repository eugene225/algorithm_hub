import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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
        while (true) {
            markOutsideAir();

            int melted = meltCheese();
            if (melted == 0) break;

            time++;

            // 외부 공기 표시 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == -1) map[i][j] = 0;
                }
            }
        }

        System.out.println(time);
    }

    // 외부 공기를 -1로 표시하는 BFS
    private static void markOutsideAir() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            map[x][y] = -1; // 외부 공기 표시

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M &&
                        !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static int meltCheese() {
        List<int[]> toMelt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int airCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M &&
                                map[ni][nj] == -1) {
                            airCount++;
                        }
                    }
                    if (airCount >= 2) {
                        toMelt.add(new int[]{i, j});
                    }
                }
            }
        }

        for (int[] pos : toMelt) {
            map[pos[0]][pos[1]] = 0;
        }

        return toMelt.size();
    }
}
