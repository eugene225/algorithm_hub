import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
        int cnt = 0;
        for(int[] command: commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] ar = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(ar);
            answer[cnt++] = ar[k-1];
        }
        
        return answer;
    }
}