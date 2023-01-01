import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        Long sum = 0L;
        while(pq.size() > 1){
            Long a = pq.poll();
            Long b = pq.poll();

            sum += a + b;
            pq.add(a+b);
        }

        System.out.println(sum);

        br.close();
    }
}