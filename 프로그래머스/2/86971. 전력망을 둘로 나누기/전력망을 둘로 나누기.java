import java.util.*;

class Solution {
    
    private static int[][] map;
    private static boolean[][] visited;
    private static int N, ans;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        N = n;
        
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        ans = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true; visited[j][i] = true;
                    map[i][j] = 0; map[j][i] = 0;
                    int cnt1 = find(i);
                    int cnt2 = find(j);
                    ans = Math.min(ans, Math.abs(cnt1-cnt2));
                    map[i][j] = 1; map[j][i] = 1;
                }
            }
        }
        return ans;
    }
    
    private static int find(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisit = new boolean[N+1];
        
        q.offer(start);
        isVisit[start] = true;
        
        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            isVisit[now] = true;
            for(int i=1; i<=N; i++) {
                if(map[now][i] == 1 && !isVisit[i]) {
                    q.offer(i);
                }
            }
            cnt++;
            //System.out.println(q);
        }
        
        return cnt;
    }
}