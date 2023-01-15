import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int A,B,C;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(B));
    }

    public static long pow(int exp){
        if(B==0) return 1;
        if(exp==1) return A%C;

        long tmp = pow(exp/2);

        if(exp % 2 ==1){
            return (((tmp * tmp) % C) * A) % C;
        }
        else return (tmp * tmp) % C;
    }
}