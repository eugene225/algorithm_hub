import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static int[] ar;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ar = new int[M];

        find(1, 0);

    }

    public static void find(int idx, int cnt){
        if(cnt==M){
            for(int val: ar){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }

        for(int i=idx;i<=N;i++){
            ar[cnt] = i;
            find(i, cnt+1);
        }

    }
}