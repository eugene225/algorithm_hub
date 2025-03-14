import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] wheels = new String[4];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            wheels[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] directions = new int[4];
            directions[index] = direction;

            // 왼쪽 방향 확인
            for (int left = index - 1; left >= 0; left--) {
                if (isSame(left, left + 1)) break;
                directions[left] = -directions[left + 1];
            }

            // 오른쪽 방향 확인
            for (int right = index + 1; right < 4; right++) {
                if (isSame(right - 1, right)) break;
                directions[right] = -directions[right - 1];
            }

            // 실제 회전 수행
            for (int j = 0; j < 4; j++) {
                if (directions[j] != 0) {
                    wheels[j] = rotate(wheels[j], directions[j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i].charAt(0) == '1') {
                result += Math.pow(2, i);
            }
        }
        System.out.println(result);
    }

    private static String rotate(String wheel, int direction) {
        if (direction == 1) { // 시계 방향
            return wheel.charAt(7) + wheel.substring(0, 7);
        } else { // 반시계 방향
            return wheel.substring(1) + wheel.charAt(0);
        }
    }

    private static boolean isSame(int front, int now) {
        return wheels[front].charAt(2) == wheels[now].charAt(6);
    }
}
