import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, X;
    static int[] ar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ar = new int[N+1];
        ar[0] = X;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            ar[i] = ar[i-1] + Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if(ar[i] < K) cnt[i] = cnt[i - 1] + 1;
            else cnt[i] = cnt[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) - 1;
            
            sb.append(cnt[end] - cnt[start - 1]).append("\n");
        }
        
        System.out.println(sb);
    }
}