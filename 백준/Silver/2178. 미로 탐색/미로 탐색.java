import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    public static void find(int x, int y){
        if(box[x][y]==0) return;

        //System.out.println("x : "+ x + ", y : "+y+", box:"+box[x][y]);
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            //System.out.println("nx : "+ nx + ", ny : "+ny+", box:"+box[x][y]);
            if(nx==0 && ny == 0) continue;
            if(nx>=0 && ny>=0 && nx < N && ny < M){
                if(box[nx][ny]!= 0 && (box[nx][ny]==1 || box[nx][ny] > box[x][y] + 1)){
                    box[nx][ny] = box[x][y] + 1;
                    find(nx, ny);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //N : 상자의 세로 , M : 상자의 가로
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        find(0,0);

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(box[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(box[N-1][M-1]);
    }
}