import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static int[] nums, tmp;
    static boolean[] visited;

    static LinkedHashSet<String> ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        tmp = new int[M];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        find(0);

        for(String str : ans){
            System.out.println(str);
        }
    }

    public static void find(int cnt){
        if(cnt==M){
            sb = new StringBuilder();
            for(int val: tmp){
                sb.append(val).append(' ');
            }
            ans.add(sb.toString());
            return;
        }

        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            tmp[cnt] = nums[i];
            find(cnt+1);
            visited[i] = false;
        }
    }

}