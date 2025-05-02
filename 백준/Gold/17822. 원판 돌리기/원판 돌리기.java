import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static int N, M, T;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            deleteSameNum();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void rotate(int x, int d, int k) {
        for (int i = x; i <= N; i += x) {
            if (d == 0) { // 시계방향
                for (int j = 0; j < k; j++) {
                    int tmp = map[i - 1][M - 1]; // 해당 줄의 마지막 원소 저장
                    for (int m = M - 1; m > 0; m--) { // 마지막 칸 쪽으로 한칸 밀기
                        map[i - 1][m] = map[i - 1][m - 1];
                    }
                    map[i - 1][0] = tmp;
                }
            } else { // 반시계 방향
                for (int j = 0; j < k; j++) {
                    int tmp = map[i - 1][0]; // 해당 줄의 첫번째 원소 저장
                    for (int m = 0; m < M - 1; m++) {
                        map[i - 1][m] = map[i - 1][m + 1];
                    }
                    map[i - 1][M - 1] = tmp;
                }
            }
        }
    }

    // 삭제한 원소는 0
    private static void deleteSameNum() {
        boolean[][] isDeleted = new boolean[N][M];
        boolean flag = false; // 인접하면서 같은수가 있음

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                int num = map[i][j];

                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = (j + dy[d] + M) % M;

                    if (ni < 0 || ni >= N) continue;

                    if (num == map[ni][nj]) {
                        isDeleted[i][j] = true;
                        isDeleted[ni][nj] = true;
                        flag = true;
                    }
                }
            }
        }

        if (flag) {
            deleteAll(isDeleted);
        } else {
            adjustAvg();
        }
    }

    private static void deleteAll(boolean[][] isDeleted) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isDeleted[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void adjustAvg() {
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    sum += map[i][j];
                    cnt++;
                }
            }
        }

        if (cnt == 0) return;
        double avg = (double) sum / cnt;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                if (map[i][j] > avg) {
                    map[i][j]--;
                } else if (map[i][j] < avg) {
                    map[i][j]++;
                }
            }
        }
    }
}