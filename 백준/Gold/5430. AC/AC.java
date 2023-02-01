import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, n;
    static String p;
    static Deque<Integer> q;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){

            p = br.readLine();
            n = Integer.parseInt(br.readLine());

            q = new LinkedList<>();
            String ar = br.readLine();
            ar = ar.substring(1, ar.length()-1);

            StringTokenizer st = new StringTokenizer(ar,",");
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }

            int start = 0;
            int flag = 0;
            for(int i=0;i<p.length();i++){
                String str = p.substring(i, i+1);

                if(str.equals("R")){
                    if(start==0) start = q.size();
                    else start = 0;
                }else{  //"D"
                    if(!q.isEmpty() && start == 0) q.pollFirst();
                    else if(!q.isEmpty() && start != 0) q.pollLast();
                    else {
                        flag = 1;
                        break;
                    }
                }
            }

            if(flag == 1) sb.append("error\n");
            else{
                sb.append("[");
                if(start == 0){
                    while(!q.isEmpty()){
                        if(q.size()==1) sb.append(q.pollFirst());
                        else sb.append(q.pollFirst()+",");
                    }
                }else{
                    while(!q.isEmpty()){
                        if(q.size()==1) sb.append(q.pollLast());
                        else sb.append(q.pollLast()+",");
                    }
                }
                sb.append("]\n");
            }

        }

        System.out.print(sb);
    }

}