import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int n, m;
    static int p1, p2;
    static List<Integer>[] list;
    static int ans = -1;
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<n+1;i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        dfs(p1, p2, 0);

        System.out.print(ans);
    }

    public static void dfs(int x, int y, int cnt){
        if(x==y){
            ans = cnt;
            return;
        }

        visited[x] = true;
        for(int i=0;i<list[x].size();i++){
            int next = list[x].get(i);
            if(!visited[next]){
                dfs(next, y, cnt+1);
            }
        }

    }

}