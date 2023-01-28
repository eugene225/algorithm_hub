import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, H; //가로, 세로, 높이
    static int[] dx = {-1, 0, 1, 0, 0, 0}; //상하좌우위아래
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] box;
    static Queue<tomato> q;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        q = new LinkedList<>();

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1) q.add(new tomato(i,j,k));
                }
            }
        }

        System.out.print(BFS());
    }

    public static int BFS() {

        while(!q.isEmpty()){
            tomato to = q.remove();

            int x = to.x;
            int y = to.y;
            int z = to.z;

            for(int i=0;i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx>=0 && ny>=0 && nz>=0 && nx<N && ny<M && nz<H){
                    if(box[nz][nx][ny]==0){
                        q.add(new tomato(nz, nx, ny));
                        box[nz][nx][ny] = box[z][x][y] + 1;
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(box[i][j][k]==0) return -1;

                    ans = Math.max(ans, box[i][j][k]);
                }
            }
        }

        if(ans == 1) return 0;
        else return ans-1;
    }

    public static class tomato{
        int x,y,z;
        public tomato(int z, int x, int y){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}