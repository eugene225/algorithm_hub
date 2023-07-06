import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int V,E;
    static int[][] graph;
    static int[] parent;
    static int final_cost;  // 최종적으로 연결된 최소 신장 트리 연결 비용
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[E][3];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        parent = new int[V];
        final_cost = 0;

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i=0;i<V;i++){
            parent[i] = i;
        }

        for(int i=0;i<E;i++){
            // 사이클이 존재하지 않는 경우에만 간선을 선택 (최종비용만 고려)
            if(find(graph[i][0] - 1) != find(graph[i][1] - 1)){
                union(graph[i][0]-1, graph[i][1] - 1);
                final_cost += graph[i][2];
                continue;
            }
        }
        System.out.println(final_cost);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a>b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }

}