import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] ar;
    static int[] LIS;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ar = new int[N];
        LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = ar[0];
        int lastIdx = 1;
        for(int i=1;i<N;i++) {

            if(ar[i] > LIS[lastIdx-1]) {
                LIS[lastIdx++] = ar[i];
            }
            else{
                int min = 0;
                int max = lastIdx;

                while(min < max) {
                    int mid = (min+max)/2;
                    if(LIS[mid] < ar[i]) min = mid+1;
                    else max = mid;
                }
                
                LIS[min] = ar[i];
            }
        }


        System.out.println(lastIdx);

    }



}