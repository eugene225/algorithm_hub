import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] money;
    static int N, MAX;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        money = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(money);

        MAX = Integer.parseInt(br.readLine());

        int min = 0;
        int max = money[N-1];

        while(min <= max) {
            int mid = (min + max) /2;

            if(can(mid) <= MAX) {
                min = mid+1;
            }else {
                max = mid-1;
            }
        }

        System.out.println(max);

    }

    public static long can(int mid) {
        long sum = 0;

        for(int i=0; i<N; i++) {
            if(mid > money[i]) {
                sum += money[i];
            }else {
                sum += mid;
            }
        }

        return sum;
    }


}