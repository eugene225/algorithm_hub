import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, K;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        for(int t=0; t<M+K; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) { // b 번째 수를 c로 변경
                segmentTree.update(b, c);
            }else if(a == 2) { // b번째 수부터 c번째 수까지의 합 출력
                long sum = segmentTree.query(b, (int) c);
                sb.append(sum).append("\n");
            }

        }

        System.out.print(sb);
    }

    public static class SegmentTree {
        long[] tree;
        int size;

        SegmentTree(long[] arr) {
            int n = arr.length - 1;
            size = 1;
            while (size < n) size *= 2;
            tree = new long[size * 2];
            build(arr, n);
        }

        void build(long[] arr, int n) {
            for (int i = 1; i <= n; i++) {
                tree[size + i - 1] = arr[i];
            }
            for (int i = size - 1; i > 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        void update(int b, long c) {
            int node = size + b - 1;
            tree[node] = c;
            while (node > 1) {
                node /= 2;
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

        long query(int left, int right) {
            int l = size + left - 1;
            int r = size + right - 1;
            long sum = 0;
            while (l <= r) {
                if (l % 2 == 1) sum += tree[l++];
                if (r % 2 == 0) sum += tree[r--];
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }


}
