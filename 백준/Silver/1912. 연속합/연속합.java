import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static int ar[];
    static int dp[];
    static int max;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = ar[0];
        max = dp[0];
        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1]+ar[i], ar[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }

}