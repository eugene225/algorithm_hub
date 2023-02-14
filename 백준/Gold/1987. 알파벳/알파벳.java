import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};  //상하좌우
    static char map[][];
    static boolean alpha[];
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        alpha = new boolean[26];

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0,0,1);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int cnt){
        alpha[map[x][y]-'A'] = true;
        ans = Math.max(ans, cnt);

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

            if(!alpha[map[nx][ny]-'A']){
                dfs(nx, ny, cnt+1);
                alpha[map[nx][ny]-'A'] = false;
            }
        }
    }

}