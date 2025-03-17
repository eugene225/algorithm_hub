import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] arr;
    private static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = 0;

        // 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int cnt) {
        if (cnt == 5) {
            findMax();
            return;
        }

        int[][] backup = copyArray(arr);

        // 네 가지 방향으로 이동시키기: 0-오른쪽, 1-왼쪽, 2-위, 3-아래
        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(cnt + 1);
            arr = copyArray(backup);
        }
    }

    private static void move(int dir) {
        switch (dir) {
            case 0: // 오른쪽
                for (int i = 0; i < N; i++) {
                    Stack<Integer> stack = new Stack<>();
                    boolean merged = false;
                    for (int j = N - 1; j >= 0; j--) {
                        if (arr[i][j] != 0) {
                            if (!stack.isEmpty() && stack.peek() == arr[i][j] && !merged) {
                                stack.push(stack.pop() * 2);
                                merged = true;
                            } else {
                                stack.push(arr[i][j]);
                                merged = false;
                            }
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        arr[i][N - 1 - j] = stack.size() > j ? stack.get(j) : 0;
                    }
                }
                break;

            case 1: // 왼쪽
                for (int i = 0; i < N; i++) {
                    Stack<Integer> stack = new Stack<>();
                    boolean merged = false;
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] != 0) {
                            if (!stack.isEmpty() && stack.peek() == arr[i][j] && !merged) {
                                stack.push(stack.pop() * 2);
                                merged = true;
                            } else {
                                stack.push(arr[i][j]);
                                merged = false;
                            }
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = stack.size() > j ? stack.get(j) : 0;
                    }
                }
                break;

            case 2: // 위
                for (int j = 0; j < N; j++) {
                    Stack<Integer> stack = new Stack<>();
                    boolean merged = false;
                    for (int i = 0; i < N; i++) {
                        if (arr[i][j] != 0) {
                            if (!stack.isEmpty() && stack.peek() == arr[i][j] && !merged) {
                                stack.push(stack.pop() * 2);
                                merged = true;
                            } else {
                                stack.push(arr[i][j]);
                                merged = false;
                            }
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        arr[i][j] = stack.size() > i ? stack.get(i) : 0;
                    }
                }
                break;

            case 3: // 아래
                for (int j = 0; j < N; j++) {
                    Stack<Integer> stack = new Stack<>();
                    boolean merged = false;
                    for (int i = N - 1; i >= 0; i--) {
                        if (arr[i][j] != 0) {
                            if (!stack.isEmpty() && stack.peek() == arr[i][j] && !merged) {
                                stack.push(stack.pop() * 2);
                                merged = true;
                            } else {
                                stack.push(arr[i][j]);
                                merged = false;
                            }
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        arr[N - 1 - i][j] = stack.size() > i ? stack.get(i) : 0;
                    }
                }
                break;
        }
    }

    private static void findMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(arr[i][j], ans);
            }
        }
    }

    private static int[][] copyArray(int[][] src) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = src[i].clone();
        }
        return copy;
    }
}
