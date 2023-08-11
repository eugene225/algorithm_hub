class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public void dfs(String[] words, String begin, String target, int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i=0;i<words.length;i++) {
            if(visited[i]) continue;
            
            int tmp = 0;
            for(int j=0;j<begin.length();j++) {
                if(begin.charAt(j) == words[i].charAt(j)) tmp++;
            }
            
            if(tmp==begin.length()-1) {
                visited[i] = true;
                dfs(words, words[i], target, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        
        dfs(words, begin, target, 0);
        
        return answer;
    }
}