class Solution {
    static int answer;
    static boolean visited[];
    
    public void dfs(int n, int idx, int[][] computers) {
        visited[idx] = true;
        
        for(int i=0;i<n;i++) {
            if(!visited[i] && computers[idx][i] == 1) {
                dfs(n, i, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) visited[i] = false;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                answer++;
                dfs(n,i,computers);
            }
        }
        
        return answer;
    }
}