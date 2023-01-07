import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int[][] all;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        all = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                if(Integer.parseInt(st.nextToken())==1) all[i][j] = 1;
                else all[i][j] = 0;
            }
        }
        paper(0,0,N);
        System.out.print(white+"\n"+blue);
    }

    public static void paper(int i, int j, int size){
        if(check(i,j,size)){
            if(all[i][j] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        paper(i,j,size/2);
        paper(i,j+size/2, size/2);
        paper(i+size/2, j, size/2);
        paper(i+size/2, j+size/2, size/2);
    }

    public static boolean check(int i, int j, int size){
        int first = all[i][j];

        for(int m=i;m<i+size;m++){
            for(int n=j;n<j+size;n++){
                if(all[m][n] != first) return false;
            }
        }
        return true;
    }
}
