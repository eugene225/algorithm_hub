import java.util.*;

class Solution {
    
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static int answer;
    static int visited[][];
    
    public int solution(int[][] maps) {
        
        visited = new int[maps.length][maps[0].length];
        bfs(maps);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer==0) answer = -1;
        
        return answer;
    }
    
    public void bfs(int maps[][]) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        
        while(!q.isEmpty()) {
            Point now = q.remove();
            
            for(int i=0;i<4;i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx<0 || nx>maps.length-1 || ny<0 || ny>maps[0].length-1)
                    continue;
                
                if(visited[nx][ny]==0 && maps[nx][ny]==1) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
}

class Point{
    int x,y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}