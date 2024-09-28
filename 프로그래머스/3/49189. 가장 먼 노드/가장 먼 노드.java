import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++) {
            int v = edge[i][0];
            int w = edge[i][1];
            
            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        
        boolean[] visited = new boolean[n+1];
        
        return bfs(edge, visited, n);
    }
    
    private static int bfs(int[][] edge, boolean[] visited, int n) {
        Queue<int[]> q = new LinkedList<>();
        int ans = 1;
        
        q.add(new int[] {1, 0});
        visited[1] = true;
        int maxDepth = 0;
        
        while(!q.isEmpty()) {
            int[] ar = q.poll();
            int v = ar[0];
            int dep = ar[1];
            
            if(maxDepth == dep) {
                ans++;
            } else if (maxDepth < dep) {
                maxDepth = dep;
                ans = 1;
            }
            
            for(int i=0; i<graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);
                if(!visited[next]){
                    q.add(new int[] {next, dep+1});
                    visited[next] = true;
                }
            }
        }
        
        return ans;
    }
}