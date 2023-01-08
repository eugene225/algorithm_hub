import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String stA = st.nextToken();
        String stB = st.nextToken();

        String stA_max = stA.replaceAll("5","6");
        String stB_max = stB.replaceAll("5", "6");

        Long max = Long.parseLong(stA_max) + Long.parseLong(stB_max);

        String stA_min = stA.replaceAll("6","5");
        String stB_min = stB.replaceAll("6", "5");

        Long min = Long.parseLong(stA_min) + Long.parseLong(stB_min);

        System.out.println(min+" "+max);
    }
}