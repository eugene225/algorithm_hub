import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String[] map;
    static int[] red;
    static int[] blue;
    static int[] hole;

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];
        red = new int[2];
        blue = new int[2];
        hole = new int[2];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine();
            for(int j=0; j<M; j++) {
                if(map[i].charAt(j) == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if(map[i].charAt(j) == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                } else if(map[i].charAt(j) == 'O') {
                    hole[0] = i;
                    hole[1] = j;
                }
            }
        }

        dfs(0);

        System.out.println(0);
    }
    
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 위, 아래, 왼, 오
    
    private static void dfs(int depth) {
        if(depth == 10) {
            return;
        }

        int prevRedX = red[0], prevRedY = red[1];
        int prevBlueX = blue[0], prevBlueY = blue[1];

        for(int d=0; d<4; d++) {
            move(dir[d][0], dir[d][1]);

            dfs(depth + 1);

            red[0] = prevRedX; red[1] = prevRedY;
            blue[0] = prevBlueX; blue[1] = prevBlueY;
        }
    }

    private static void move(int dx, int dy) {
        int rX = red[0], rY = red[1];
        int bX = blue[0], bY = blue[1];

        boolean redFirst = (dx == -1 && rX < bX) || (dx == 1 && rX > bX) ||
                (dy == -1 && rY < bY) || (dy == 1 && rY > bY);

        int[] newRed = moveBall(rX, rY, dx, dy);
        int[] newBlue = moveBall(bX, bY, dx, dy);

        if (map[newBlue[0]].charAt(newBlue[1]) == 'O') return; // 파란 구슬이 빠짐 → 실패
        if (map[newRed[0]].charAt(newRed[1]) == 'O') {
            ans = 1;
            System.out.println(1);
            System.exit(0);
        }

        // 두 구슬이 겹치는 경우 → 하나 뒤로
        if (newRed[0] == newBlue[0] && newRed[1] == newBlue[1]) {
            if (redFirst) {
                newBlue[0] -= dx;
                newBlue[1] -= dy;
            } else {
                newRed[0] -= dx;
                newRed[1] -= dy;
            }
        }

        red[0] = newRed[0];
        red[1] = newRed[1];
        blue[0] = newBlue[0];
        blue[1] = newBlue[1];
    }

    private static int[] moveBall(int x, int y, int dx, int dy) {
        while (true) {
            if (map[x + dx].charAt(y + dy) == '#') break;
            x += dx;
            y += dy;
            if (map[x].charAt(y) == 'O') break;
        }
        return new int[]{x, y};
    }
}