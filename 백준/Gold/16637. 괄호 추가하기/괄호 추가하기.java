import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> nums = new ArrayList<>();
    static List<Character> operators = new ArrayList<>();
    static int maxResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums.add(str.charAt(i) - '0');
            } else {
                operators.add(str.charAt(i));
            }
        }

        if (N == 1) {
            System.out.println(nums.get(0));
            return;
        }

        maxResult = Integer.MIN_VALUE;
        dfs(0, nums.get(0));

        System.out.println(maxResult);
    }

    private static void dfs(int lastNumIdx, int sum) {
        if (lastNumIdx == nums.size() - 1) {
            maxResult = Math.max(maxResult, sum);
            return;
        }

        int resultAfterSimpleCalc = calculate(sum, operators.get(lastNumIdx), nums.get(lastNumIdx + 1));
        dfs(lastNumIdx + 1, resultAfterSimpleCalc);

        if (lastNumIdx + 2 < nums.size()) {
            int nextVal = calculate(
                    nums.get(lastNumIdx + 1),
                    operators.get(lastNumIdx + 1),
                    nums.get(lastNumIdx + 2)
            );

            int resultWithNextVal = calculate(sum, operators.get(lastNumIdx), nextVal);
            dfs(lastNumIdx + 2, resultWithNextVal);
        }
    }

    private static int calculate(int n1, char op, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return 0;
    }
}