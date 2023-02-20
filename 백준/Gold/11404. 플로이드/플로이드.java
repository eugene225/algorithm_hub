import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static int N, M;
    static int map[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = INF;

                if(i==j) map[i][j] = 0;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(map[i][j] == INF){
                    map[i][j] = 0;
                }
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}