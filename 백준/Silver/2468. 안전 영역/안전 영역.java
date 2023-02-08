import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};  //상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int max_h = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max_h = Math.max(max_h, map[i][j]);
            }
        }

        int h = 0;
        ans = 0;

        while(true){
            if(h>max_h) break;

            int cnt = 0;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j] && map[i][j] > h){
                        dfs(i, j, h);
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);
            h++;
        }


        System.out.print(ans);
    }

    public static void dfs(int x, int y, int h){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny] > h){
                dfs(nx,ny,h);
            }
        }
    }

}