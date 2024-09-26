import java.io.*;

class Solution {
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            visited[i] = false;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int num, boolean[] visited, int[][] computers) {
        visited[num] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(!visited[i] && computers[num][i]==1) {
                dfs(i, visited, computers);
            }
        }
    }
}