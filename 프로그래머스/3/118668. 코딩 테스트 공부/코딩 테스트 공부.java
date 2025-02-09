import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int alpMax = 0; int copMax = 0;
        for(int[] problem: problems) {
            //System.out.println("problem : " + problem[0] + ", " + problem[1]);
            alpMax = Math.max(alpMax, problem[0]);
            copMax = Math.max(copMax, problem[1]);
        }
        
        int[][] dp = new int[alpMax+2][copMax+2];
        for(int[] ar: dp) {
            Arrays.fill(ar, Integer.MAX_VALUE);
        }
        
        alp = Math.min(alp, alpMax);
        cop = Math.min(cop, copMax);
        
        dp[alp][cop] = 0;
        for(int i=alp; i<=alpMax; i++) {
            for(int j=cop; j<=copMax; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] problem: problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nAlp = Math.min(alpMax, i + problem[2]);
                        int nCop = Math.min(copMax, j + problem[3]);
                        dp[nAlp][nCop] = Math.min(dp[nAlp][nCop], dp[i][j] + problem[4]);
                    }
                }
                
                //System.out.println("dp[" + i + "][" + j + "] : " + dp[i][j]);
            }
        }
        
        return dp[alpMax][copMax];
    }
    
    private static boolean canSolve(int alp, int cop, int[] problem) {
        return alp >= problem[0] && cop >= problem[1];
    }
}