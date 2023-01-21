import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

        dp[0] = 0L;
        dp[1] = 1L;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }

}