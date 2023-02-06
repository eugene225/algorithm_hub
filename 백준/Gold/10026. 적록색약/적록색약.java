import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};  //상 하 좌 우
    static int[] dy = {0, 0 ,-1, 1};
    static int ans1, ans2;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                map[i][j] = s.charAt(j);
            }
        }

        ans1 = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs_1(i, j);
                    ans1++;
                }
            }
        }

        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        ans2 = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs_1(i, j);
                    ans2++;
                }
            }
        }

        System.out.print(ans1 +" "+ ans2);
    }

    public static void dfs_1(int x, int y){
        visited[x][y] = true;
        char tmp = map[x][y];

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny]==tmp){
                dfs_1(nx, ny);
            }
        }

    }

}