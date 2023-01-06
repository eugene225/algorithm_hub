import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int ans;
    static int[][] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
        //6개 패키지 가격 " " 1개 낱개 가격
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            q1.add(Integer.parseInt(st.nextToken()));
            q2.add(Integer.parseInt(st.nextToken()));
        }

        ans = Math.min(((N/6)+1)*q1.peek(), N*q2.peek());
        ans = Math.min(ans, ((N/6) * q1.peek()) + (N%6) * q2.peek());

        System.out.println(ans);
    }
}