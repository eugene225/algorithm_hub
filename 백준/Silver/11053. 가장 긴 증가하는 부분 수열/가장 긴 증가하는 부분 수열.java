import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static Integer[] ar;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new Integer[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            find(i);
        }

        int max = dp[0];
        for(int i=1;i<N;i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static int find(int idx){
        if(dp[idx] == null){
            dp[idx] = 1;

            for(int i=idx-1; i>=0; i--){
                if(ar[i] < ar[idx]) {
                    dp[idx] = Math.max(dp[idx], find(i) + 1);
                }
            }
        }
        return dp[idx];
    }
}