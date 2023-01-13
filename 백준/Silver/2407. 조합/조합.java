import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BigInteger num1 = BigInteger.ONE, num2 = BigInteger.ONE;

        for(int i=N; i>N-M; i--){
            num1 = num1.multiply(new BigInteger(String.valueOf(i)));
        }

        for(int i=M; i>0; i--){
            num2 = num2.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(num1.divide(num2));
    }
}