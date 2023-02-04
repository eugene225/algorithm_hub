import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copy;
    static int dx[] = {-1, 1, 0, 0};  //상하좌우
    static int dy[] = {0, 0, -1, 1};
    static int ans = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    static class virus{
        int x,y;
        public virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        copy = map;

        DFS(0);

        System.out.print(ans);
    }

    public static void DFS(int depth){
        if(depth == 3){
            BFS();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS(){
        int[][] virus_map = new int[N][M];
        Queue<virus> q = new LinkedList<virus>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                virus_map[i][j] = map[i][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(virus_map[i][j] == 2){
                    q.add(new virus(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            virus v = q.remove();

            for(int i=0;i<4;i++){
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if(nx>=0 && ny>=0 && nx < N && ny < M){
                    if(virus_map[nx][ny]==0){
                        virus_map[nx][ny] = 2;
                        q.add(new virus(nx, ny));
                    }
                }
            }
        }

        safe(virus_map);
    }

    public static void safe(int virus_map[][]){
        int cnt = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(virus_map[i][j] == 0) cnt++;
            }
        }

        ans = Math.max(ans, cnt);
    }

}
