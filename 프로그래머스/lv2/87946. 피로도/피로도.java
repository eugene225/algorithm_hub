class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        
        find(k, dungeons, 0);
        
        return answer;
    }
    
    public void find(int k, int[][] dungeons, int cnt) {
        if(cnt==dungeons.length) {
            answer = cnt;
            return;
        }
        
        for(int i=0;i<dungeons.length;i++) {
            if(k>=dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                find(k-dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
}