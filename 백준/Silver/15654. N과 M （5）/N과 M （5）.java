import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] ar;
    static int[] ar2;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ar = new int[N];
        ar2 = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        find(0);

        System.out.print(sb);
    }

    static void find(int cnt){
        if(cnt==M) {
            for(int i=0;i<M;i++){
                sb.append(ar2[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            ar2[cnt] = ar[i];
            find(cnt+1);
            visited[i] = false;
        }
    }

}