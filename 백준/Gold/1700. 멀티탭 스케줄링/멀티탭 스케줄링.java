import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] order;
    static boolean[] use;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        use = new boolean[101];
        int put = 0;
        int ans = 0;

        for(int i=0;i<K;i++){
            int tmp = order[i];

            if(!use[tmp]){
                if(put < N) {
                    use[tmp] = true;
                    put++;
                } else {

                    ArrayList<Integer> arrayList = new ArrayList<>();

                    for(int j=i;j<K;j++){
                        if(use[order[j]] && !arrayList.contains(order[j])) {
                            arrayList.add(order[j]);
                        }
                    }

                    if(arrayList.size()!=N) {
                        for(int j=0;j<use.length; j++) {
                            if(use[j] && !arrayList.contains(j)) {
                                use[j] = false;
                                break;
                            }
                        }
                    } else {
                        int rm = arrayList.get(arrayList.size()-1);
                        use[rm] = false;
                    }

                    use[tmp]  = true;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}