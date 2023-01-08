import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ar = new int[N];
        long ans =0;

        for (int i = 0; i <N ; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ar);

        int left = 0;
        int right = N-1;
        ans = 0;

        // 0, 음수 처리
        for (; left < right ; left+=2) {
            if(ar[left] <1 && ar[left+1] < 1){
                ans += ar[left] * ar[left+1];
            }else{
                break;
            }
        }

        // 양수일 경우 처리
        for (; right >0; right-=2) {
            // 1과는 곱하지 않게
            if(ar[right] >1 && ar[right-1] > 1){
                ans += ar[right] * ar[right-1];
            }else{
                break;
            }
        }

        //남은 값들은 더해주기
        for (; right >= left; right--) {
            ans += ar[right];
        }

        System.out.println(ans);
    }
}