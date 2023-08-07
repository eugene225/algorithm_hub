import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M*N / gcd(M, N);
            int year = x;
            int ans = -1;
            while(true) {
                if(year > lcm) break;
                else if(((year%N) == 0 ? N : year%N) == y) {
                    ans = year;
                    break;
                }
                year += M;
            }

            System.out.println(ans);
        }
    }

    public static int gcd(int n1, int n2) {
        if(n2==0) return n1;
        return gcd(n2, n1%n2);
    }
}