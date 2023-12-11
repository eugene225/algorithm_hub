import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[] table;
    private static int ans = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        table = br.readLine().toCharArray();

        for(int i = 0; i < N; i++) {
            if(table[i] == 'P') {
                int idx = Math.max(i - K, 0);
                boolean flag = false;

                for (int j = idx; j < i; j++) {
                    if (isPossible(j)) {
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    idx = i + K >= N ? N -1 : i+ K;
                    for(int j=i+1; j<=idx; j++) {
                        if(isPossible(j)) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
    
    private static boolean isPossible(int idx) {
        if(table[idx] == 'H') {
            table[idx] = 'X';
            ans++;
            return true;
        }
        return false;
    }
}