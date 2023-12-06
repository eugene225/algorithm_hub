import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N,M;
    static HashSet<String> A = new HashSet<>();
    static ArrayList<String> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            A.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String str = br.readLine();
            if(A.contains(str)) {
                result.add(str);
            }
        }

        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for(String str: result) {
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }
}