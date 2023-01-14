import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE / 16;
    static int N, M, A, B;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==1 && !visited[i][j]){
                    find(i, j);
                    pq.add(cnt);
                    cnt = 0;
                }
            }
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    static void find(int x, int y){
        if(board[x][y]==0 || visited[x][y]) return;

        cnt++;
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                find(nx, ny);
            }
        }
    }
}