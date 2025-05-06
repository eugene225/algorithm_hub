import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Set<String> set = new HashSet<>();
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[10];
        dfs(0, "");
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            Set<String> tmpSet = new HashSet<>();

            for(String num: set) {
                boolean isFit = checkNumber(num, now, strike, ball);
                if(isFit) {
                   tmpSet.add(num);
                }
            }

            set = new HashSet<>(tmpSet);
            ans = set.size();
        }

        System.out.println(ans);
    }

    private static void dfs(int depth, String number) {
        if(depth == 3) {
            set.add(number);
            return;
        }

        for(int i=1; i<=9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, number+i);
                visited[i] = false;
            }
        }
    }

    private static boolean checkNumber(String num, int now, int strike, int ball) {
        String[] numArr = num.split("");
        String[] nowArr = String.valueOf(now).split("");

        int strikeCount = 0;
        int ballCount = 0;

        for(int i=0; i<3; i++) {
            if(numArr[i].equals(nowArr[i])) {
                strikeCount++;
            } else if(numArr[i].equals(nowArr[(i+1)%3]) || numArr[i].equals(nowArr[(i+2)%3])) {
                ballCount++;
            }
        }

        return strikeCount == strike && ballCount == ball;
    }

}
