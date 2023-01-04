import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, ans;
    static int []visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N==K){
            System.out.println(0);
            return;
        }

        visited = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        int idx = N;
        int n = 0;
        visited[idx] = 1;

        while(!q.isEmpty()){
            n = q.remove();

            if(n==K) {
                ans = visited[n]-1;
                break;
            }

            if(n-1 >= 0 && visited[n-1]==0){
                visited[n-1] = visited[n]+1;
                q.add(n-1);
            }
            if(n+1 <= 100000 && visited[n+1] == 0){
                visited[n+1] = visited[n] + 1;
                q.add(n+1);
            }
            if(n*2 <= 100000 && visited[n*2] == 0){
                visited[n*2] = visited[n] + 1;
                q.add(n*2);
            }
        }

        System.out.println(ans);
    }
}