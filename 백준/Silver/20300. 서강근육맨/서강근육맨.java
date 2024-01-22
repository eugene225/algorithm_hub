import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long ans;
    static long[] ar;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        ar = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            ar[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(ar);

        ans = 0;
        if(N%2==0) {
            for(int i=0; i<N/2; i++) {
                ans = Math.max(ar[i]+ar[N-1-i], ans);
            }
        } else {
            ans = ar[N-1];
            for (int i=0; i<(N-1)/2; i++) {
                ans = Math.max(ar[i] + ar[N-2-i], ans);
            }
        }

        System.out.println(ans);
    }
}