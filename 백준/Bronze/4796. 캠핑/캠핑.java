import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int P, L, V, cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = 1;
        while(true){  //P일 중 L일 동안만 이용  강산이는 V일짜리 휴가 시작
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if(P==0 && L==0 && V==0) break;

            int ans = 0;
            ans += V/P * L;
            if((V%P) > L) ans += L;
            else ans += (V%P);

            System.out.println("Case "+cnt+": "+ans);
            cnt++;
        }

        br.close();
    }
}