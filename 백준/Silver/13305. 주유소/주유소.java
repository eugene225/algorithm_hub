import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Long [] load = new Long[N-1];
        Long [] money = new Long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            load[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            money[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long cost = money[0];
        for(int i=0;i<N-1;i++){
            if(money[i] < cost){
                cost = money[i];
            }
            sum += cost * load[i];
        }

        System.out.println(sum);
    }
}