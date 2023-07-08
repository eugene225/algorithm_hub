import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, m;
    static int map[][];
    static int distance[][];
    static boolean isVisited[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int startX = -1;
        int startY = -1;

        map = new int[n][m];
        distance = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1 && !isVisited[i][j]) sb.append("-1 ");
                else sb.append(distance[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        isVisited[x][y] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0) continue;
                if(isVisited[nx][ny]) continue;

                q.add(new Point(nx, ny));
                distance[nx][ny] = distance[now.x][now.y] + 1;
                isVisited[nx][ny] = true;
            }
        }
    }

}