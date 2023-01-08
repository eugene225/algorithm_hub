import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static int x1,y1,x2,y2;
    static int[][] ar;
    static int[][] ar_sum;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  //표의 크기
        M = Integer.parseInt(st.nextToken());  //횟수

        ar = new int[N+1][N+1];
        ar_sum = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ar_sum[1][1] = ar[1][1];

        for(int i=1;i<=N;i++){
            ar_sum[i][1] = ar_sum[i-1][1] + ar[i][1];
        }

        for(int i=1;i<=N;i++){
            ar_sum[1][i] = ar_sum[1][i-1] + ar[1][i];
        }

        for(int i=2;i<=N;i++){
            for(int j=2;j<=N;j++){
                ar_sum[i][j] = ar_sum[i-1][j] + ar_sum[i][j-1] - ar_sum[i-1][j-1] + ar[i][j];
            }
        }

        sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            findSum();
        }
        System.out.print(sb);
    }

    static void findSum(){
        int sum = ar_sum[x2][y2];

        if(x1-1>=1){
            sum -= ar_sum[x1-1][y2];
        }

        if(y1-1>=1){
            sum -= ar_sum[x2][y1-1];
        }

        if(x1-1>=1 && y1-1>=1){
            sum += ar_sum[x1-1][y1-1];
        }

        sb.append(sum+"\n");
    }
}