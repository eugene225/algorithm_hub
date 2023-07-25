import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long ar[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            ar[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(ar);

        int l = 0;
        int r = N-1;

        int ans1 = 0, ans2 = 0;
        long min = Long.MAX_VALUE;

        while(l < r) {
            long sum = ar[l] + ar[r];
            if(min >= Math.abs(sum)) {
                min = Math.abs(sum);
                ans1 = l; ans2 = r;
            }

            if(sum >= 0) r--;
            else l++;
        }

        System.out.println(ar[ans1] + " " + ar[ans2]);

    }

}