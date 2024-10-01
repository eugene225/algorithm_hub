class Solution {
    
    private static int ans;
    
    public int solution(int[] numbers, int target) {
        ans = 0;
        dfs(numbers, 0, 0, target);
        
        return ans;
    }
    
    private static void dfs(int[] numbers, int idx, int tar, int target) {
        if(idx == numbers.length && tar == target) {
            ans = ans + 1;
            return;
        }
        if(idx == numbers.length) return;
        
        dfs(numbers, idx+1, tar + numbers[idx], target);
        dfs(numbers, idx+1, tar - numbers[idx], target);
    }
}