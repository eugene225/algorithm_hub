import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Long A, B;
    static int ans;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(A, 1);

        if(flag) System.out.println(ans);
        else System.out.println(-1);

        br.close();
    }

    public static void dfs(long num, int cnt){
        if(num > B) return;
        if(num == B) {
            ans = cnt;
            flag = true;
            return;
        }

        dfs(num*2, cnt+1);
        dfs(num*10+1, cnt+1);
    }
}