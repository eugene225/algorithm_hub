import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        cnt = 0;

        find(0);
        System.out.println(cnt);
    }

    static void find(int depth){
        if(depth == N){
            cnt++;
            return;
        }

        for(int i=0;i<N;i++){
            dp[depth] = i;

            if(possible(depth)){
                find(depth+1);
            }
        }
    }

    static boolean possible(int col){
        for(int j=0;j<col;j++){
            if( (dp[col] == dp[j]) || (Math.abs(col-j) == Math.abs(dp[col]-dp[j])) ){
                return false;
            }
        }
        return true;
    }
}