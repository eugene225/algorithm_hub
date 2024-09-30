import java.util.*;

public class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps) {
        visited[0][0] = 1;
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            int cx = now.getX();
            int cy = now.getY();
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1) continue;
                
                if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
}