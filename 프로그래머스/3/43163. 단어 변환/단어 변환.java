import java.util.*;

class Solution {
    
    private static boolean[] visited;
    private static int ans;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(words, begin, 0, target);
        
        return ans;
    }
    
    private void dfs(String[] words, String now, int step, String target) {
        if(now.equals(target)) {
            ans = step;
            return;
        }
        if(step == words.length) {
            ans = 0;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visited[i] && isNextWord(now, words[i])) {
                visited[i] = true;
                dfs(words, words[i], step+1, target);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isNextWord(String s1, String s2) {
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == 1;
    }
}