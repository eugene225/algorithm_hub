import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] count = new int[10];
        int digitPlace = 1;

        while(N / digitPlace > 0) {
            int higher = N / (digitPlace * 10);
            int cur = (N / digitPlace) % 10;
            int lower = N % digitPlace;

            for(int i = 0; i < 10; i++) {
                if(i < cur) {
                    count[i] += (higher + 1) * digitPlace;
                } else if(i == cur) {
                    count[i] += higher * digitPlace + (lower + 1);
                } else {
                    count[i] += higher * digitPlace;
                }
            }

            count[0] -= digitPlace;

            digitPlace *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb);
    }
}