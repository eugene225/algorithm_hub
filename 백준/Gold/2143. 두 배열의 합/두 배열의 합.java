import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long T;
    private static int n, m;
    private static long[] a;
    private static long[] b;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        T = Long.parseLong(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        b = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Long> sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                sumA.add(sum);
            }
        }

        ArrayList<Long> sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        int pointerA = 0;
        int pointerB = sumB.size() - 1;
        long count = 0;

        while (pointerA < sumA.size() && pointerB >= 0) {
            long currentA = sumA.get(pointerA);
            long currentB = sumB.get(pointerB);
            long total = currentA + currentB;

            if (total == T) {
                long countA = 0;
                long countB = 0;
                long tempA = currentA;
                long tempB = currentB;
                while (pointerA < sumA.size() && sumA.get(pointerA) == tempA) {
                    countA++;
                    pointerA++;
                }
                while (pointerB >= 0 && sumB.get(pointerB) == tempB) {
                    countB++;
                    pointerB--;
                }
                count += countA * countB;
            } else if (total < T) {
                pointerA++;
            } else {
                pointerB--;
            }
        }

        System.out.println(count);
    }
}
