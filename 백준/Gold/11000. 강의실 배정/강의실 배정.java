import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class lecture{
    int start;
    int end;

    public lecture(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    static int N;
    static lecture list[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new lecture[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[i] = new lecture(start, end);
        }

        Arrays.sort(list, (l1, l2) -> l1.start==l2.start ? l1.end-l2.end : l1.start-l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list[0].end);

        for(int i=1;i<N;i++){
            if(pq.peek() <= list[i].start){
                pq.poll();
            }
            pq.offer(list[i].end);
        }

        System.out.println(pq.size());

    }

}