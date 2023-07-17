import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int ans = 0;
        while(n > 0){

            if(n % 5 == 0) {
                ans += n/5;
                break;
            }

            n -= 2;
            ans++;
        }

        if(n < 0) System.out.println(-1);
        else System.out.println(ans);
    }

}