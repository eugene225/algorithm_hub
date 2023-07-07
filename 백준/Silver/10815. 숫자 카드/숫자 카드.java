import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int ar[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ar = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());

            if(binarySearch(num)) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int num){
        int leftIdx = 0;
        int rightIdx = N-1;

        while(leftIdx <= rightIdx){
            int midIdx = (leftIdx + rightIdx) / 2;
            int mid = ar[midIdx];

            if(num < mid) rightIdx = midIdx -1;
            else if(num > mid) leftIdx = midIdx + 1;
            else return true;
        }
        return false;
    }

}