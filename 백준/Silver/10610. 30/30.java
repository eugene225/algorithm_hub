import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        int len = number.length();
        int []num = new int[len];

        int sum=0;
        for(int i=0;i<len;i++){
            num[i] = Integer.parseInt(number.substring(i, i+1));
            sum += num[i];
        }

        Arrays.sort(num);

        if(num[0]!=0 || sum%3 != 0){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=len-1;i>=0;i--){
            sb.append(num[i]);
        }

        System.out.println(sb);
    }
}