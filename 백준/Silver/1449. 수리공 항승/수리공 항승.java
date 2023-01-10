import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,L;
    static int[] hole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // hole 개수
        L = Integer.parseInt(st.nextToken());  // 테이프의 길이

        hole = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            hole[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hole);

        int position = hole[0];
        int tape = 0;
        int cnt = 0;
        for(int i=0;i<N;i++){
            position = hole[i];
            if(position > tape){
                tape = position+L-1;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}