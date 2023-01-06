import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class tomato{
    int x;
    int y;

    public tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    static Queue<tomato> q;
    public static int find(){
        while(!q.isEmpty()){
            tomato t = q.remove();

            int x = t.x;
            int y = t.y;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(box[nx][ny]==0){
                        q.add(new tomato(nx, ny));
                        box[nx][ny] = box[x][y] + 1;
                    }
                }
            }
        }

        int day = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j]==0){
                    return -1;
                }
                day = Math.max(day, box[i][j]);
            }
        }

        if(day == 1) return 0;
        else return (day-1);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //N : 상자의 세로 , M : 상자의 가로
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        q = new LinkedList<tomato>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    q.add(new tomato(i, j));
                }
            }
        }

        System.out.println(find());
    }
}