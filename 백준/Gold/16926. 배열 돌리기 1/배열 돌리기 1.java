import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int layer = 0; layer < layers; layer++) {
                rotateLayer(layer);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void rotateLayer(int layer) {
        int top = layer;
        int left = layer;
        int bottom = N - 1 - layer;
        int right = M - 1 - layer;

        int temp = map[top][left];

        // 위 -> 오
        for (int i = left; i < right; i++) {
            map[top][i] = map[top][i + 1];
        }
        // 오 -> 아래
        for (int i = top; i < bottom; i++) {
            map[i][right] = map[i + 1][right];
        }
        // 아래 → 왼
        for (int i = right; i > left; i--) {
            map[bottom][i] = map[bottom][i - 1];
        }
        // 왼쪽 -> 위
        for (int i = bottom; i > top + 1; i--) {
            map[i][left] = map[i - 1][left];
        }

        map[top + 1][left] = temp;
    }
}