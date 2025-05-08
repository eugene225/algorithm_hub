import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            result.clear();
            int end = Integer.parseInt(br.readLine());
            dfs(1, end, "");
            Collections.sort(result);
            for(String str : result) {
                String origin = str;
                String[] nums = str.split("(?=[+-])");
                boolean flag = checkIsZero(nums);
                if(flag) sb.append(origin).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkIsZero(String[] nums) {
        int sum = 0;
        //System.out.println(Arrays.deepToString(nums));
        for(String num : nums) {
            num = num.trim();
            num = num.replace(" ", "");

            if(num.contains("+")) {
                String number = num.substring(1, num.length());
                //System.out.println("number = " + number);
                sum += Integer.parseInt(number);
            }else if(num.contains("-")) {
                String number = num.substring(1, num.length());
                //System.out.println("number = " + number);
                sum -= Integer.parseInt(number);
            }else {
                sum += Integer.parseInt(num);
            }
        }

        //System.out.println("sum = " + sum);
        return sum == 0;
    }

    static char[] arr = {'+', '-', ' '};

    static void dfs(int start, int end, String now) {
        if (start == end) {
            now += start;
            result.add(now);
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(start + 1, end, now + start + arr[i]);
        }
    }

}