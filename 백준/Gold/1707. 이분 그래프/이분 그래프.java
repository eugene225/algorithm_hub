import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int K,V,E;
    static ArrayList<Integer> ar[];
    static int visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for(int tc=0;tc<K;tc++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());  //정점의 수
            E = Integer.parseInt(st.nextToken());  //간선의 수

            ar = new ArrayList[V+1];
            visited = new int[V+1];
            for(int i=1;i<=V;i++){
                ar[i] = new ArrayList<>();
            }

            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                ar[start].add(end);
                ar[end].add(start);
            }

            bfs();

        }

        System.out.print(sb);
    }

    static public void bfs(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=V;i++){
            if(visited[i]==0){
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()){
                int now = q.poll();

                for(int j=0;j<ar[now].size();j++){
                    if(visited[ar[now].get(j)] == 0){
                        q.add(ar[now].get(j));
                    }

                    if(visited[ar[now].get(j)] == visited[now]){
                        sb.append("NO\n");
                        return;
                    }

                    if(visited[now] == 1 && visited[ar[now].get(j)] == 0){
                        visited[ar[now].get(j)] = 2;
                    }else if(visited[now] == 2 && visited[ar[now].get(j)] == 0){
                        visited[ar[now].get(j)] = 1;
                    }
                }
            }
        }

        sb.append("YES\n");
    }

}