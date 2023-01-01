import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        char ch1, ch2;
        if(S.charAt(0)=='0') {
            ch1 = '0';
            ch2 = '1';
        }
        else {
            ch1 = '1';
            ch2 = '0';
        }

        int cnt = 0;
        for(int i=0;i<S.length()-1;i++){
            if(S.charAt(i) == ch1 && S.charAt(i+1) == ch2){
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}