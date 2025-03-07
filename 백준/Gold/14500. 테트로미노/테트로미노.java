import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, ans;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

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

        ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                checkSpecialShape(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isCorrect(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    private static void checkSpecialShape(int x, int y) {
        // ㅗ 모양
        if (isCorrect(x, y + 1) && isCorrect(x, y - 1) && isCorrect(x + 1, y)) {
            int sum = map[x][y] + map[x][y + 1] + map[x][y - 1] + map[x + 1][y];
            ans = Math.max(ans, sum);
        }

        // ㅜ 모양
        if (isCorrect(x, y + 1) && isCorrect(x, y - 1) && isCorrect(x - 1, y)) {
            int sum = map[x][y] + map[x][y + 1] + map[x][y - 1] + map[x - 1][y];
            ans = Math.max(ans, sum);
        }

        // ㅓ 모양
        if (isCorrect(x + 1, y) && isCorrect(x - 1, y) && isCorrect(x, y - 1)) {
            int sum = map[x][y] + map[x + 1][y] + map[x - 1][y] + map[x][y - 1];
            ans = Math.max(ans, sum);
        }

        // ㅏ 모양
        if (isCorrect(x + 1, y) && isCorrect(x - 1, y) && isCorrect(x, y + 1)) {
            int sum = map[x][y] + map[x + 1][y] + map[x - 1][y] + map[x][y + 1];
            ans = Math.max(ans, sum);
        }
    }

    private static boolean isCorrect(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}