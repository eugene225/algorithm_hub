import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id, banned_id, new HashSet<>(), visited, 0);
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, Set<String> currentSet, boolean[] visited, int depth) {
        if (depth == banned_id.length) {
            result.add(new HashSet<>(currentSet));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && matches(banned_id[depth], user_id[i])) {
                visited[i] = true;
                currentSet.add(user_id[i]);
                
                dfs(user_id, banned_id, currentSet, visited, depth + 1);
                
                visited[i] = false; 
                currentSet.remove(user_id[i]);
            }
        }
    }
    
    private boolean matches(String banned, String user) {
        if (banned.length() != user.length()) return false;
        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
