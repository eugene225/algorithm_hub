import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E, K;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());  //정점의 수
        E = Integer.parseInt(st.nextToken());  //간선의 수
        K = Integer.parseInt(br.readLine());  //시작 정점의 번호

        graph = new ArrayList[V+1];
        for(int i=0;i<=V;i++) graph[i] = new ArrayList<Node>();

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, value));
        }

        Dijkstra(V, K);

        System.out.print(sb);
    }

    public static void Dijkstra(int n, int start) {
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int vertex = pq.poll().idx;

            if(visited[vertex]) continue;
            visited[vertex] = true;

            for(Node next : graph[vertex]){
                if(dist[next.idx] > dist[vertex] + next.value){
                    dist[next.idx] = dist[vertex] + next.value;

                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for(int i=1;i<=V;i++){
            if(dist[i]==INF) sb.append("INF\n");
            else sb.append(dist[i]+"\n");
        }
    }

    static class Node implements Comparable<Node>{
        int idx;
        int value;

        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return (this.value - o.value);
        }
    }

}