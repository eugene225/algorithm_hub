class Solution {
    
    private static int[][] ar;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        ar = new int[m][n];
        ar[0][0] = 1;
        
        for(int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            ar[x][y] = -1;
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) continue;
                if(ar[i][j] == -1) {
                    ar[i][j] = 0;
                    continue;
                }
                
                if (i > 0) ar[i][j] += (ar[i-1][j] == -1 ? 0 : ar[i-1][j]) % 1000000007; // 위쪽에서 오는 경우
                if (j > 0) ar[i][j] += (ar[i][j-1] == -1 ? 0 : ar[i][j-1]) % 1000000007; // 왼쪽에서 오는 경우
                ar[i][j] %= 1000000007;
            }
        }
        
        answer = ar[m-1][n-1] % 1000000007;
        return answer;
    }
}