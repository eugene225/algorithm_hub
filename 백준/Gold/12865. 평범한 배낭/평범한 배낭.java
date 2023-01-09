import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int [][] item;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 아이템 개수
        K = Integer.parseInt(st.nextToken());  // 가방 최대 무게

        item = new int[N+1][2];
        dp = new int[N+1][K+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            item[i][0] = Integer.parseInt(st.nextToken());  // item W(무게)
            item[i][1] = Integer.parseInt(st.nextToken());  // item V(가치)
        }

        for(int k=1;k<=K;k++){  // 1~K무게까지 채우기
            for (int i=1;i<=N;i++){  // 1~N 아이템까지 채우기
                dp[i][k] = dp[i-1][k];

                if(k - item[i][0] >= 0){  // 현재 무게에서 현재 아이템의 무게를 뺐을 때, 남는 무게가 있으면
                    dp[i][k] = Math.max(dp[i-1][k], item[i][1] + dp[i-1][k-item[i][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}