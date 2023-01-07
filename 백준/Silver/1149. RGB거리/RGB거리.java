import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, ans;
    static int [][] money;
    static int [][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        money = new int[N+1][3];
        house = new int[N+1][3];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            money[i][0] = Integer.parseInt(st.nextToken());
            money[i][1] = Integer.parseInt(st.nextToken());
            money[i][2] = Integer.parseInt(st.nextToken());
        }


        for(int j=1;j<=N;j++){
            house[j][0] = Math.min(house[j-1][1], house[j-1][2]) + money[j][0];
            house[j][1] = Math.min(house[j-1][0], house[j-1][2]) + money[j][1];
            house[j][2] = Math.min(house[j-1][0], house[j-1][1]) + money[j][2];
        }

        System.out.println(Math.min(Math.min(house[N][0], house[N][1]), house[N][2]));
    }
}