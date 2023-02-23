import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int X,N,a,b;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        long sum=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum += a*b;
        }

        if(sum==X) System.out.print("Yes");
        else System.out.print("No");
    }

}