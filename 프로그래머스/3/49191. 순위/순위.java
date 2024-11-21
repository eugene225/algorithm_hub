class Solution {
    private static int[][] graph;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        graph = new int[n+1][n+1];
        for(int[] result: results) {
            int win = result[0]; int lose = result[1];
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if(graph[i][k] == -1 && graph[k][j] == -1) { 
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(graph[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}