import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static HashMap<Character, Integer> map;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            map = new HashMap<>();
            String str = br.readLine();

            boolean flag = false;
            for(int j=0;j<str.length();j++){
                if(j!=0 && map.get(str.charAt(j))!=null && map.get(str.charAt(j))!=0 && str.charAt(j-1) != str.charAt(j)){
                    flag = true;
                    break;
                }
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
            }

            if(!flag) cnt++;
        }

        System.out.println(cnt);

    }

}