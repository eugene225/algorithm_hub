import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class jewel{
    int M;  //무게
    int V;  //가격

    public jewel(int M, int V){
        this.M = M;
        this.V = V;
    }
}

public class Main {
    static int N, K;
    static int[] bag_w;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewel []ar = new jewel[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            ar[i] = new jewel(M, V);
        }

        bag_w = new int[K];
        for(int i=0;i<K;i++){
            bag_w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ar, new Comparator<jewel>() {
            @Override
            public int compare(jewel o1, jewel o2) {
                if(o1.M == o2.M){
                    return o2.V - o1.V;
                }
                return o1.M - o2.M;
            }
        });

//        for(int i=0;i<N;i++){
//            System.out.println("jewel"+(i+1)+" - M:"+ar[i].M+", V:"+ar[i].V);
//        }

        Arrays.sort(bag_w);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for(int i=0, j=0; i< K;i++){
            while(j < N && ar[j].M <= bag_w[i]){
                pq.offer(ar[j++].V);
            }

            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        System.out.println(ans);

        br.close();
    }
}