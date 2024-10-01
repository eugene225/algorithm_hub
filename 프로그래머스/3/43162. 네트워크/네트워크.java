import java.util.*;

class Solution {
    
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        graph = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(graph.get(idx).get(0));
        visited[idx] = true;
        
        int ans = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i=0; i<graph.get(now).size(); i++) {
                int child = graph.get(now).get(i);
                if(!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
            }
        }
    }
}