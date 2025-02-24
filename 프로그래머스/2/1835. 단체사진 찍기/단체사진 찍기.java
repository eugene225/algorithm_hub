import java.util.*;

class Solution {
    
    private static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private static boolean[] visited;
    private static int ans;
    
    public int solution(int n, String[] data) {
        ans = 0;
        
        visited = new boolean[8];
        dfs("", data);
        
        return ans;
    }
    
    private static void dfs(String line, String[] data) {
        if(line.length() == 8) {
            if(check(line, data)) {
                ans++;
            }
            return;
        }
        
        for(int i=0; i<friends.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(line+friends[i], data);
                visited[i] = false;
            }
        }
    }
    
    private static boolean check(String line, String[] data) {
        for(String d: data) {
            int first = line.indexOf(d.charAt(0));
            int second = line.indexOf(d.charAt(2));
            char op = d.charAt(3);
            int len = Integer.parseInt(String.valueOf(d.charAt(4)));
            
            switch(op){
                case '=':
                    if (Math.abs(first - second) - 1 != len) return false;
                    break;
                case '>':
                    if (Math.abs(first - second) - 1 <= len) return false;
                    break;
                case '<':
                    if (Math.abs(first - second) - 1 >= len) return false;
                    break;
            }

        }
        
        return true;
    }
}