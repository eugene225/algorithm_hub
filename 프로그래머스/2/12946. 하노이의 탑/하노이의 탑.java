import java.util.*;

class Solution {
    
    private static List<int[]> arr = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = {};
        
        hanoi(n, 1,2,3);
        answer = arr.stream().toArray(int[][]::new);
        
        return answer;
    }
    
    private static void hanoi(int cnt, int start, int mid, int end) {
        if(cnt == 0) {
            return;
        }
        
        hanoi(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end});
        hanoi(cnt-1, mid, start, end);
    }
}