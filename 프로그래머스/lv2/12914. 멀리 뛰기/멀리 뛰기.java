class Solution {
    private int dp[];
    
    //재귀 시간초과 -> dp 이용
    public long solution(int n) {
        long answer = 0;

        dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=2000;i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }

        answer = dp[n];
        
        return answer;
    }
}