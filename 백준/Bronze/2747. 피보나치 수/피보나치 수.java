import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N+1];
        num[0] = 0;
        num[1] = 1;

        for(int i=2;i<=N;i++){
            num[i] = num[i-1]+num[i-2];
        }

        System.out.println(num[N]);
    }
}