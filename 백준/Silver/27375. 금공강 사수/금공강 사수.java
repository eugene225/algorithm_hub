import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Lesson {
        private int day, start, end, credit;

        public Lesson(int day, int start, int end, int credit) {
            this.day = day;
            this.start = start;
            this.end = end;
            this.credit = credit;
        }
    }

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static List<Lesson> lessons = new ArrayList<>();
    static boolean[][] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (w != 5) {
                lessons.add(new Lesson(w, s, e, e - s + 1));
            }
        }

        visited = new boolean[5][11];
        solution(k, 0, 0, lessons);

        System.out.print(ans);
    }

    private static void solution(int K, int cnt, int start, List<Lesson> lessons) {
        if(cnt == K) {
            ans++;
            return;
        }
        for(int i=start; i<lessons.size(); i++) {
            if(isPossible(lessons.get(i))) {
                changeStatus(lessons.get(i), true);

                solution(K, cnt+lessons.get(i).credit, i+1, lessons);

                changeStatus(lessons.get(i), false);
            }
        }
    }

    private static void changeStatus(Lesson lesson, boolean status) {
        for(int i=lesson.start; i<= lesson.end; i++) {
            visited[lesson.day][i] = status;
        }
    }

    private static boolean isPossible(Lesson lesson) {
        for(int i=lesson.start; i<= lesson.end; i++) {
            if(visited[lesson.day][i]) return false;
        }
        return true;
    }

}