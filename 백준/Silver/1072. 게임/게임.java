import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long X;
    static long Y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        long Z = (int) (Y*100/X);
        int ans = -1;

        if(Z < 99) {
            ans = (int) Math.ceil( (X*(Z+1) - 100*Y) / (double) (99-Z) );
        }

        System.out.println(ans);
    }
}