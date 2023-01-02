import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, ans;
    static int []alpha;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        alpha = new int[26];

        for(int i=0;i<N;i++){
            String str = br.readLine();

            for(int j=0;j<str.length();j++){
                alpha[str.charAt(j) - 'A'] += (Math.pow(10, str.length()-j-1));
            }
        }

        Arrays.sort(alpha);

        int num = 9;

        ans = 0;
        for(int i=25;i>=0;i--){
            ans += (alpha[i]*num);
            num--;
        }

        System.out.println(ans);

        br.close();
    }
}