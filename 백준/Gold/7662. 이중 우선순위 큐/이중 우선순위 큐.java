import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static TreeMap<Integer, Integer> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){

            int N = Integer.parseInt(br.readLine());

            que = new TreeMap<>();

            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                char ch = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(ch=='I'){
                    que.put(num, que.getOrDefault(num, 0) + 1);
                }
                else{
                    if(que.size() == 0) continue;

                    int n;
                    if(num == 1) n = que.lastKey();
                    else n = que.firstKey();

                    if(que.put(n, que.get(n) - 1) == 1) que.remove(n);
                }
            }

            if(que.size()==0) System.out.println("EMPTY");
            else System.out.println(que.lastKey() + " " + que.firstKey());
        }

    }
}