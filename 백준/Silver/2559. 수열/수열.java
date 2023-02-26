import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, K;
    static int ar[];
    static int dp[];
    static int ans = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ar = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        int cnt=0;

        dp[0] = ar[0];

        for(int i=1;i<K;i++) dp[i] = dp[i-1]+ar[i];

        ans = dp[K-1];
        for(int i=K;i<N;i++){
            dp[i] = dp[i-1] + ar[i] - ar[cnt++];
            //System.out.println("i="+i+", dp[i]="+dp[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }

}