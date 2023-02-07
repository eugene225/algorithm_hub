import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int w,h;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};  //상 하 좌 우 상좌 상우 하좌 하우
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());  //너비
            h = Integer.parseInt(st.nextToken());  //높이

            if(w==0 && h==0) break;
//            if(w==1 && h==1){
//                sb.append(0+"\n");
//                continue;
//            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && map[i][j]==1){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt+"\n");
        }


        System.out.print(sb);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<h && ny<w && !visited[nx][ny] && map[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }

}