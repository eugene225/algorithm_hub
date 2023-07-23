import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] ar;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ar = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        int l = 0;
        int r = N-1;

        int min = Integer.MAX_VALUE;
        int sum, tmp;

        int ans1 = 0;
        int ans2 = 0;
        while(l<r) {
            sum = ar[l] + ar[r];
            tmp = Math.abs(sum);

            if(tmp < min) {
                min = tmp;
                ans1 = ar[l];
                ans2 = ar[r];
            }

            if(sum > 0) r--;
            else l++;
        }


        System.out.println(ans1 + " " + ans2);

    }



}