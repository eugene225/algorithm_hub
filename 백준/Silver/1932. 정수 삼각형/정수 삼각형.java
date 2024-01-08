import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] dp;
    private static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];

        dp[0][0] = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ans = dp[0][0];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);

    }
}