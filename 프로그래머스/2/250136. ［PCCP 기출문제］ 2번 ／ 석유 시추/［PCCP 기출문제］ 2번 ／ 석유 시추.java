import java.util.*;

class Solution {
    
    private static boolean[][] visited;
    private static int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        
        oil = new int[m];
        visited = new boolean[n][m];
        
        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                if(land[j][i] == 1 && !visited[j][i]) {
                    bfs(land, j, i);
                }
            }
        }
        
        Arrays.sort(oil);
        
        return oil[oil.length-1];
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    private void bfs(int[][] land, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            set.add(now[1]);
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && ny>=0 && nx<land.length && ny<land[0].length && land[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt += 1;
                }
            }
        }
        
        for(int idx : set) {
            oil[idx] += cnt;
        }
    }
}