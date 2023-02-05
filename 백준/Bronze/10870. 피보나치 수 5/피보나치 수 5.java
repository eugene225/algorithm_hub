import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = find(N);


        System.out.print(ans);
    }

    public static int find(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        return find(n-1) + find(n-2);
    }

}