import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A,B,C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if(A <= B && B<= C || C <= B && B<=A) System.out.println(B);
        else if(B<=A && A<=C || C<=A && A<=B) System.out.println(A);
        else if(A<=C && C<=B || B<=C && C<=A) System.out.println(C);
    }

}