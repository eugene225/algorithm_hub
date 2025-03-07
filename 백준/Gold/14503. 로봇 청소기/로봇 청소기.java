import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, d;
    private static int[][] map;
    private static int[] now;
    private static int ans = 0;

    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        now = new int[2];
        st = new StringTokenizer(br.readLine());
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(isNotCleaned()) {
                map[now[0]][now[1]] = 2; // 청소 완료 표시
                ans++;
            }

            boolean noClean = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
                    noClean = false;
                    break;
                }
            }

            if(noClean) {
                boolean flag = moveBack();
                if(!flag) break;
            } else {
                d = (d + 3) % 4; // 반시계 방향 회전
                moveFront();
            }
        }

        System.out.println(ans);
    }

    private static boolean isNotCleaned() {
        return map[now[0]][now[1]] == 0;
    }

    private static boolean moveBack() {
        int dir = (d + 2) % 4;
        int nx = now[0] + dx[dir];
        int ny = now[1] + dy[dir];

        if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 1) {
            now[0] = nx;
            now[1] = ny;
            return true;
        }
        return false;
    }

    private static void moveFront() {
        int nx = now[0] + dx[d];
        int ny = now[1] + dy[d];

        if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
            now[0] = now[0] + dx[d];
            now[1] = now[1] + dy[d];
        }
    }
}
