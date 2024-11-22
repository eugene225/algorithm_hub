class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;

        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]==1) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen*maxLen;
    }
}