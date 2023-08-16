class Solution {
    
    static int[] gInfo;
    static int[][] gEdges;
    static int maxSheepCnt = 0;
    
    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        
        boolean[] isVisited = new boolean[info.length];
        dfs(0, isVisited, 0, 0);
        
        return maxSheepCnt;
    }
    
    public void dfs(int idx, boolean[] isVisited, int sheepCnt, int wolfCnt) {
        isVisited[idx] = true;
        
        if(gInfo[idx]==0) {
            sheepCnt++;
            if(sheepCnt > maxSheepCnt) {
                maxSheepCnt = sheepCnt;
            }
        }else {
            wolfCnt++;
        }
        
        if(sheepCnt <= wolfCnt) return;
        
        for(int[] edge : gEdges) {
            if(isVisited[edge[0]] && !isVisited[edge[1]]) {
                boolean[] nextVisited = new boolean[isVisited.length];
                for(int i=0;i<isVisited.length; i++) {
                    nextVisited[i] = isVisited[i];
                }
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
            }
        }
    }
}