import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE / 16;
    static int N, M, A, B;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int dist[];
    static int sum;

    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, value));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        System.out.println(find(A, B));

    }

    static int find(int start, int dest){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int start_node = node.end;

            if(!visited[start_node]) {
                visited[start_node] = true;

                for(Node end_nodes : graph.get(start_node)) {

                    if(!visited[end_nodes.end] && (dist[end_nodes.end] > (dist[start_node] + end_nodes.value)) ) {
                        dist[end_nodes.end] = dist[start_node] + end_nodes.value;
                        pq.offer(new Node(end_nodes.end, dist[end_nodes.end]));
                    }
                }
            }
        }

        return dist[dest];
    }
}