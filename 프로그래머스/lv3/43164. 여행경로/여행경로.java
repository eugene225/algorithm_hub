import java.util.*;

class Solution {
    static String[] answer;
    static boolean[] visited;
    static ArrayList<String> route;
    
    public String[] solution(String[][] tickets) {
        this.answer = answer;
        visited = new boolean[tickets.length];
        route = new ArrayList<>();
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(route);
        answer = route.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String[][] tickets, String start, String end, int cnt){
        //System.out.println("start : "+ start + ", end : " + end + ", cnt : "+ cnt);
    
        if(cnt == tickets.length) {
            route.add(end);
            //System.out.println("route : "+ route.get(0));
            return;
        }
        
        for(int i=0;i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], end+" "+tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
    
}