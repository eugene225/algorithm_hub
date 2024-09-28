import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> link;
    private static int[][] cost = new int[300001][2];
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        link = new ArrayList<>();
        for (int i = 0; i <= sales.length; i++) {
            link.add(new ArrayList<>());
        }

        
        for(int i=0; i<links.length; i++) {
            int a = links[i][0];
            int b = links[i][1];
            link.get(a).add(b);
        }
        
        dfs(sales, 1);
        
        answer = Math.min(cost[1][0], cost[1][1]);
        return answer;
    }
    
    private static void dfs(int[] sales, int idx) {
        cost[idx][0] = 0;
        cost[idx][1] = sales[idx-1];
        
        if(link.get(idx).size() == 0) return;
        
        int ex = (int)1e9;
        for(int child: link.get(idx)) {
            dfs(sales, child);
            
            if(cost[child][0] < cost[child][1]) {
                cost[idx][0] += cost[child][0];
                cost[idx][1] += cost[child][0];
                
                ex = Math.min(ex, cost[child][1] - cost[child][0]);
            } else {
                cost[idx][0] += cost[child][1];
                cost[idx][1] += cost[child][1];
                
                ex = 0;
            }
        }
        
        cost[idx][0] += ex;
    }
}