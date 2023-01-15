import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static char[][] ar;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new char[N][N];

        star(0,0, N, false);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(ar[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void star(int x, int y, int n, boolean blank){
        if(blank){
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    ar[i][j] = ' ';
                }
            }
            return;
        }

        if(n==1) {
            ar[x][y] = '*';
            return;
        }

        int size = n/3;
        int cnt = 0;
        for(int i=x;i<x+n;i+=size){
            for(int j=y;j<y+n;j+=size){
                cnt++;
                if(cnt==5){
                    star(i, j, size, true);
                }else{
                    star(i, j, size, false);
                }
            }
        }
    }
}