import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};  //상하좌우
    static int map[][];
    static int cnt = 0;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int tc=1;tc<=K;tc++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            for(int i=sy;i<ly;i++){
                for(int j=sx;j<lx;j++){
                    map[i][j] = 1;
                }
            }
        }

        list = new ArrayList<Integer>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 0){
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        System.out.println(list.size());

        Collections.sort(list);

        for(Integer val : list) System.out.print(val + " ");
    }

    public static void dfs(int x, int y){
        map[x][y] = 1;
        cnt++;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;

            if(map[nx][ny]==0){
                dfs(nx, ny);
            }
        }
    }

}