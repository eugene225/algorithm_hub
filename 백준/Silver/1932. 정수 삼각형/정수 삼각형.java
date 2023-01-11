import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] tri;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());  // N줄의 삼각형
        //System.out.println("N:"+N);

        dp = new Integer[N][N];
        tri = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
                //System.out.print(tri[i][j]+" ");
            }
            //System.out.println();
        }

        for(int i=0;i<N;i++){
            dp[N-1][i] = tri[N-1][i];
        }

        System.out.println(find(0, 0));
    }

    public static int find(int depth, int idx){
        if(depth == N-1){
            return dp[depth][idx];
        }

        if(dp[depth][idx] == null){
            dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + tri[depth][idx];
        }
        return dp[depth][idx];
    }
}