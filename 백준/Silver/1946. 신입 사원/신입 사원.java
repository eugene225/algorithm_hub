import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class member{
    int write;
    int face;

    public member(){
        this.write = 0;
        this.face = 0;
    }

    public member(int write, int face){
        this.write = write;
        this.face = face;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N;

        for(int i=0;i<T;i++){

            N = Integer.parseInt(br.readLine());

            member []ar = new member[N];
            for(int j=0;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int write = Integer.parseInt(st.nextToken());
                int face = Integer.parseInt(st.nextToken());
                ar[j] = new member(write, face);
            }

            Arrays.sort(ar, new Comparator<member>() {

                @Override
                public int compare(member o1, member o2) {
                    if(o1.write == o2.write){
                        return o1.face-o2.face;
                    }
                    return o1.write - o2.write;
                }

            });

            int cnt = 1;
            int min_cnt = ar[0].face;
            for(int j=1;j<N;j++){
                if(ar[j].face < min_cnt){
                    cnt++;
                    min_cnt = ar[j].face;
                }
            }

            System.out.println(cnt);
        }

        br.close();
    }
}