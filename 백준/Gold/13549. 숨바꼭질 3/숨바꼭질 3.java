import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,K;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        find(visited);

        System.out.println(ans);
    }

    public static void find(boolean[] visited){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == K) ans = Math.min(ans, node.time);

            if(node.x * 2 < 100001 && !visited[node.x*2]) q.offer(new Node(node.x * 2 , node.time));
            if(node.x + 1 < 100001 && !visited[node.x+1]) q.offer(new Node(node.x + 1 , node.time+1));
            if(node.x - 1 >= 0 && !visited[node.x-1]) q.offer(new Node(node.x - 1 , node.time+1));
        }
    }

    static class Node{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

}