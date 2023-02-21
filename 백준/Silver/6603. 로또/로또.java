import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int k;
    static StringBuilder sb = new StringBuilder();
    static int ar[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k==0) break;

            ar = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                ar[i] = Integer.parseInt(st.nextToken());
            }

            find(0,0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void find(int idx, int cnt){
        if(cnt==6){
            for(int i=0;i<k;i++){
                if(visited[i]) sb.append(ar[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i<k;i++){
            visited[i] = true;
            find(i+1, cnt+1);
            visited[i] = false;
        }
    }

}