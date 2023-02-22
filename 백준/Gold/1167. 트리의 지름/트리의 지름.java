import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, ans, node;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node> ar[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ar = new ArrayList[N+1];
        for(int i=1;i<=N;i++) ar[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int now = Integer.parseInt(st.nextToken());

            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int val = Integer.parseInt(st.nextToken());
                ar[now].add(new Node(end, val));
            }
        }

        visited = new boolean[N+1];
        dfs(1,0);

        visited = new boolean[N+1];
        dfs(node, 0);

        System.out.print(ans);
    }

    public static void dfs(int x, int len){
        if(len>ans){
            ans = len;
            node = x;
        }

        visited[x] = true;
        for(int i=0;i<ar[x].size();i++){
            Node now = ar[x].get(i);
            if(!visited[now.end]){
                visited[now.end] = true;
                dfs(now.end, now.val + len);
            }
        }
    }

    static public class Node{
        int end;
        int val;

        public Node(int end, int val){
            this.end = end;
            this.val = val;
        }
    }

}