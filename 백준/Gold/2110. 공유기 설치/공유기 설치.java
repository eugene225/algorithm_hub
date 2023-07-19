import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] house;
    static int N, C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //System.out.println("N : "+N+", C : "+C);

        house = new int[N];
        for(int i=0;i<N;i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int min = 1;
        int max = house[N-1] - house[0]  + 1;

        while(min < max){
            int mid = (min + max) / 2;

            if(canInstall(mid) < C) {
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(min-1);

    }

    public static int canInstall(int mid) {
        int cnt = 1;
        int last = house[0];

        for(int i=1; i< house.length; i++) {
            int now = house[i];

            if(now - last >= mid){
               cnt++;
               last = now;
            }
        }

        return cnt;
    }

}