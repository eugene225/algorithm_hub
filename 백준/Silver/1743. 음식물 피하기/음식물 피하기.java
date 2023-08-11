import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,K;
    static int[][] ar;
    static int[] dx = {0, 0 , -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ar = new int[N][M];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ar[x-1][y-1] = 1;
        }

        answer = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(ar[i][j] == 1) {
                    answer = Math.max(answer, find(i, j));
                }
            }
        }

        System.out.println(answer);

    }

    public static int find(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.add(new int[]{x, y});
        ar[x][y] = 0;

        while(!q.isEmpty()) {
            int[] dir = q.poll();
            int cx = dir[0];
            int cy = dir[1];
            cnt++;

            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

                if(ar[nx][ny] == 1) {
                    ar[nx][ny] = 0;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return cnt;
    }
}