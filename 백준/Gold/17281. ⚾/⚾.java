import java.io.*;
import java.util.*;

public class Main {
    private static int inning;
    private static int[][] inningToPlayer;
    private static boolean[] visited = new boolean[9];
    private static List<int[]> lineUps = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inning = Integer.parseInt(br.readLine());
        inningToPlayer = new int[inning][9];

        StringTokenizer st;
        for(int i=0; i<inning; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                inningToPlayer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] lineUp = new int[9];
        visited[0] = true;
        lineUp[3] = 0;

        dfs(0, lineUp);

        int maxScore = 0;

        for (int[] lu : lineUps) {
            int score = 0;
            int playerIndex = 0; // 타순 index
            for (int inn = 0; inn < inning; inn++) {
                int out = 0;
                int[] base = new int[4]; // 1루, 2루, 3루

                while (out < 3) {
                    int player = lu[playerIndex];
                    int result = inningToPlayer[inn][player];

                    if (result == 0) {
                        out++;
                    } else {
                        for (int i = 3; i >= 1; i--) {
                            if (base[i] == 1) {
                                int next = i + result;
                                if (next >= 4) {
                                    score++;
                                } else {
                                    base[next] = 1;
                                }
                                base[i] = 0;
                            }
                        }
                        if (result >= 4) {
                            score++;
                        } else {
                            base[result] = 1;
                        }
                    }

                    playerIndex = (playerIndex + 1) % 9;
                }
            }
            maxScore = Math.max(maxScore, score);
        }

        System.out.println(maxScore);
    }

    private static void dfs(int depth, int[] lineUp) {
        if (depth == 9) {
            lineUps.add(lineUp.clone());
            return;
        }

        if (depth == 3) {
            dfs(depth + 1, lineUp);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lineUp[depth] = i;
                dfs(depth + 1, lineUp);
                visited[i] = false;
            }
        }
    }
}