import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> Q[];
        Queue<String> T = new LinkedList<String>();

        N = Integer.parseInt(br.readLine());
        Q = new LinkedList[N];
        for (int i=0; i<N; i++) {
            Q[i] = new LinkedList<String>();
        }
        
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            String s[] = str.split(" ");
            for (int j=0; j<s.length; j++) {
                Q[i].add(s[j]);
            }
        }
        String tmp = br.readLine();
        String t[] = tmp.split(" ");
        for (int i=0; i<t.length; i++) {
            T.add(t[i]);
        }

        while (!T.isEmpty()) {
            String word = T.poll();
            boolean found = false;
            for (int i=0; i<N; i++) {
                //System.out.println(word+" / "+Q[i].peek());
                if (word.equals(Q[i].peek())) {
                    Q[i].poll();
                    found = true;
                }
            }
            if (!found) { 
                System.out.println("Impossible");
                return;
            }
        }
        for (int i=0; i<N; i++) { 
            while(!Q[i].isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}