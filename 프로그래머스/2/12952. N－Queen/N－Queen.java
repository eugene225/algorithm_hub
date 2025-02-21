class Solution {
    
    private static int[][] board;
    private static int[] visited;
    private static int N;
    private static int ans;
    
    public int solution(int n) {
        int answer = 0;
        
        N = n;
        board = new int[n][n];
        visited = new int[n];
        
        ans = 0;
        dfs(0);
        
        return ans;
    }
    
    private static void dfs(int cnt) {
        if(cnt == N) {
            ans++;
            return;
        }
        
        for(int i=0; i<N; i++) {
            visited[cnt] = i;
            boolean isCheck = false;
            for(int j=0; j<cnt; j++) {
                int n = visited[j];
                int m = j;
                
                if(n == i || m == cnt || Math.abs(n-i) == Math.abs(m-cnt)) {
                    visited[cnt] = -1;
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck) {
                dfs(cnt+1);
            }
        }
    }
}