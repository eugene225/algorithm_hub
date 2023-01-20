import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static int ar[];
    static int dp[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new int[N];

        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N];
        dp[0] = ar[0];

        for(int i=1; i<N;i++){
            if(i==1) {
                dp[i] = ar[0]+ar[1];
                continue;
            }
            if(i==2){
                dp[i] = Math.max(Math.max(ar[1]+ar[2], ar[0]+ar[2]), dp[1]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+ar[i], dp[i-3]+ar[i-1]+ar[i]));
        }
        System.out.print(dp[N-1]);
    }

}