import java.util.*;

class Solution {
    
    private static int N, M;
    private static int[][] visited;
    private static int ans;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];
        
        bfs(maps);
        
        ans = visited[N-1][M-1];
        if(visited[N-1][M-1] == 0) ans = -1;
        
        return ans;
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    private static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    
//     private static void dfs(int[] cur, int cnt, int[][] maps) {
//         if(cur[0] == N-1 && cur[1] == M-1) {
//             ans = Math.min(ans, cnt);
//             //System.out.println("ans : " + ans + ", cnt : " + cnt);
//             return;
//         }
        
//         for(int i=0; i<4; i++) {
//             int nx = cur[0] + dx[i];
//             int ny = cur[1] + dy[i];
            
//             if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
//             if(!visited[nx][ny] && maps[nx][ny] == 1) {
//                 visited[nx][ny] = true;
//                 dfs(new int[]{nx, ny}, cnt+1, maps);
//                 visited[nx][ny] = false;
//             }
//         }
//     }
}