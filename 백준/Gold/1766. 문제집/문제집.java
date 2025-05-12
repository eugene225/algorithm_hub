import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] inDegree;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }

        topologicalSort();

        for(int i=1; i<=N; i++) {
            System.out.print(result.get(i-1) + " ");
        }
    }

    static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++) {
            if(inDegree[i] == 0) {
                pq.add(i);
            }
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            result.add(cur);
            //System.out.println(result + " " + cur + " " + pq);

            for(int next : graph.get(cur)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }
}