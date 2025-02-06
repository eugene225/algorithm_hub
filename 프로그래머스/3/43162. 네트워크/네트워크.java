import java.util.*;

class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int idx, int[][] computers, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i=0; i<n; i++) {
                if(!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}