import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N;
    static int map[][];
    static boolean visited[][];
    static point start, end;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(br.readLine());
            end = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            bfs(start);

        }

    }

    public static void bfs(point p){
        Queue<point> q = new LinkedList<>();
        q.add(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()){
            point tmp = q.poll();
            int tmp_x = tmp.x;
            int tmp_y = tmp.y;
            int cnt = tmp.cnt;

            if(tmp_x == end.x && tmp_y == end.y){
                System.out.println(tmp.cnt);
                return;
            }

            for(int i=0;i<8;i++){
                int nx = tmp_x + dx[i];
                int ny = tmp_y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    q.add(new point(nx, ny, cnt+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class point{
        int x, y, cnt;

        public point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}