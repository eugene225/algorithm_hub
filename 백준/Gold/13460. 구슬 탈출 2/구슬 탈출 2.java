import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static char[][] map;
    private static boolean[][][][] visited;

    static int[] dx = {0, 0, -1, 1};  // 좌우상하
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.';  // 빈 칸으로 변환
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                }
            }
        }

        int result = bfs(rx, ry, bx, by);
        System.out.println(result);
    }

    private static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int rX = cur[0], rY = cur[1], bX = cur[2], bY = cur[3], depth = cur[4];

            if (depth >= 10) return -1;  // 10번 넘으면 실패

            for (int i = 0; i < 4; i++) {
                int nRx = rX, nRy = rY, nBx = bX, nBy = bY;

                // 빨간 공 이동
                while (map[nRx + dx[i]][nRy + dy[i]] != '#' && map[nRx][nRy] != 'O') {
                    nRx += dx[i];
                    nRy += dy[i];
                }
                // 파란 공 이동
                while (map[nBx + dx[i]][nBy + dy[i]] != '#' && map[nBx][nBy] != 'O') {
                    nBx += dx[i];
                    nBy += dy[i];
                }

                // 파란 공이 구멍에 빠지면 실패
                if (map[nBx][nBy] == 'O') continue;

                // 빨간 공이 구멍에 빠지면 성공
                if (map[nRx][nRy] == 'O') return depth + 1;

                // 두 공이 같은 위치라면 이동 순서에 따라 한 칸 조정
                if (nRx == nBx && nRy == nBy) {
                    int rDist = Math.abs(nRx - rX) + Math.abs(nRy - rY);
                    int bDist = Math.abs(nBx - bX) + Math.abs(nBy - bY);
                    if (rDist > bDist) {  // 빨간 공이 더 멀리 이동한 경우
                        nRx -= dx[i];
                        nRy -= dy[i];
                    } else {  // 파란 공이 더 멀리 이동한 경우
                        nBx -= dx[i];
                        nBy -= dy[i];
                    }
                }

                // 방문한 적 없으면 큐에 추가
                if (!visited[nRx][nRy][nBx][nBy]) {
                    visited[nRx][nRy][nBx][nBy] = true;
                    queue.add(new int[]{nRx, nRy, nBx, nBy, depth + 1});
                }
            }
        }
        return -1;  // 10번 내에 못 끝내면 실패
    }
}
