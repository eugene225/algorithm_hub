import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};  //상하좌우
    static int map[][];
    static boolean visited[][][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        visited = new boolean[N][M][2];
        int ans = -1;
        ans = bfs(new Point(0,0,1, false));

        System.out.println(ans);
    }

    public static int bfs(Point p){
        Queue<Point> q = new LinkedList<>();

        q.add(p);

        while(!q.isEmpty()){
            Point point = q.poll();

            if(point.x == N-1 && point.y == M-1) {
                 return point.cnt;
            }

            for(int i=0;i<4;i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                if(map[nx][ny]==0){
                    if(!point.des && !visited[nx][ny][0]){
                        q.add(new Point(nx, ny, point.cnt+1, false));
                        visited[nx][ny][0] = true;
                    }else if(point.des && !visited[nx][ny][1]){
                        q.add(new Point(nx, ny, point.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else if(map[nx][ny]==1){
                    if(!point.des){
                        q.add(new Point(nx, ny, point.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static class Point{
        int x,y,cnt;
        boolean des;
        public Point(int x, int y, int cnt, boolean des){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.des = des;
        }
    }

}