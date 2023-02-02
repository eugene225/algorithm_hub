import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 1010번 - 다리놓기
    static int T, N, M;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[N+1][M+1];

            for(int i=1;i<=M;i++){
                dp[1][i] = i;
            }

            for(int i=2;i<=N;i++){
                for(int j=2;j<=M;j++){
                    if(i<j){
                        dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                    }else if(i==j){
                        dp[i][j] = 1;
                    }
                }
            }

            sb.append(dp[N][M]+"\n");

        }


        System.out.print(sb);
    }

}