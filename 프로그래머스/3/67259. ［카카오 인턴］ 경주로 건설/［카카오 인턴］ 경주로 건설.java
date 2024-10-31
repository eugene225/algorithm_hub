import java.util.*;

class Solution {
    
    private static int costMin;
    private static int size;
    private static int[][][] cost;
    
    public int solution(int[][] board) {        
        size = board.length;
        cost = new int[size][size][4];
        for(int[][] row : cost) {
            for(int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }
        
        costMin = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            find(board, 0, 0, i, 0);
        }
        
        return costMin;
    }
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    private static void find(int[][] board, int x, int y, int dir, int curCost) {
        if(x == size-1 && y == size-1) {
            costMin = Math.min(costMin, curCost);
            //System.out.println("x : " + x + ", y : " + y + ", costMin : " + costMin);
            return;
        }
        
        if (curCost >= cost[x][y][dir]) return;
        cost[x][y][dir] = curCost;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= size || ny < 0 || ny >= size || board[nx][ny] == 1) continue;
            
            int newCost = curCost + (dir == i ? 100 : 600);
            
            if(newCost < cost[nx][ny][i]) {
                find(board, nx, ny, i, newCost);
            }
        }
    }
}