import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static List<Node>[] ar;
    static int ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            ar[i] = new ArrayList<Node>();
        }


        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            ar[from].add(new Node(to, value));
            ar[to].add(new Node(from, value));
        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.print(ans);
    }

    public static void dfs(int num , int dis){
        for(Node node : ar[num]){
            if(!visited[node.to]){
                visited[node.to] = true;
                dfs(node.to, dis + node.value);
            }
        }
        if(ans < dis) ans = dis;
    }

    public static class Node{
        int to;
        int value;

        public Node(int to, int value){
            this.to = to;
            this.value = value;
        }
    }

}