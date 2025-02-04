class Solution {
    
    private static int ans;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        ans = 0;
        dfs(0, 0, numbers, target);
        
        return ans;
    }
    
    private static void dfs(int now, int cnt, int[] numbers, int target) {
        if(cnt == numbers.length) {
            if(now == target) ans += 1;
            return;
        }
        
        dfs(now+numbers[cnt], cnt+1, numbers, target);
        dfs(now-numbers[cnt], cnt+1, numbers, target);
    }
}