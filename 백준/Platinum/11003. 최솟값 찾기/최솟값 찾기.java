import java.io.*;
import java.util.*;

public class Main {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {

            while(!deque.isEmpty() && arr[deque.getLast()] > arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if(deque.getFirst() <= i-L) { // 구간의 첫번쨰 인덱스
                deque.removeFirst();
            }

            sb.append(arr[deque.getFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}