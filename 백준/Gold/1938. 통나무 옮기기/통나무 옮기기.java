import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] map;
    static boolean[][][] visited;
    static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N];
        visited = new boolean[N][N][2];

        List<int[]> B = new ArrayList<>();
        List<int[]> E = new ArrayList<>();

        // 맵 읽기
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = map[i].charAt(j);
                if (c == 'B') B.add(new int[]{i, j});
                if (c == 'E') E.add(new int[]{i, j});
            }
        }

        // 중심 좌표와 방향 결정
        start = getCenterAndDirection(B);
        end = getCenterAndDirection(E);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], start[2], 0}); // x, y, dir, depth
        visited[start[0]][start[1]][start[2]] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2], cnt = cur[3];

            if (x == end[0] && y == end[1] && dir == end[2]) {
                System.out.println(cnt);
                return;
            }

            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canMove(nx, ny, dir) && !visited[nx][ny][dir]) {
                    visited[nx][ny][dir] = true;
                    q.offer(new int[]{nx, ny, dir, cnt + 1});
                }
            }

            // 회전
            int ndir = (dir + 1) % 2;
            if (canRotate(x, y) && !visited[x][y][ndir]) {
                visited[x][y][ndir] = true;
                q.offer(new int[]{x, y, ndir, cnt + 1});
            }
        }

        System.out.println(0);
    }

    // 중심 좌표와 방향을 반환: [x, y, dir]
    static int[] getCenterAndDirection(List<int[]> list) {
        Collections.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int x = list.get(1)[0];
        int y = list.get(1)[1];
        int dir = (list.get(0)[0] == list.get(1)[0]) ? 0 : 1; // 가로:0, 세로:1
        return new int[]{x, y, dir};
    }

    static boolean canMove(int x, int y, int dir) {
        for (int i = -1; i <= 1; i++) {
            int nx = x + (dir == 0 ? 0 : i);
            int ny = y + (dir == 0 ? i : 0);
            if (!inRange(nx, ny) || map[nx].charAt(ny) == '1') return false;
        }
        return true;
    }

    static boolean canRotate(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (!inRange(nx, ny) || map[nx].charAt(ny) == '1') return false;
            }
        }
        return true;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}