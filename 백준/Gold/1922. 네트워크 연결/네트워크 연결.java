import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[M][3];
        parent = new int[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }
        Arrays.sort(graph, (a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);

        int totalCost = 0;
        int edgeCount = 0;
        for (int i = 0; i < M; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            int cost = graph[i][2];

            if (find(a) != find(b)) {
                union(a, b);
                totalCost += cost;
                edgeCount++;
                if (edgeCount == N - 1) break;
            }
        }

        System.out.println(totalCost);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA; // rootA를 rootB의 부모로 설정
        }
    }

}