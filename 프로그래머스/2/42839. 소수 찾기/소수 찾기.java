import java.util.*;

class Solution {
    
    private static Set<Integer> set;
    private static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        find("", 0, numbers);
        
        for(Integer num: set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void find(String num, int cnt, String numbers) {
        if(cnt > numbers.length()) {
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(num + numbers.charAt(i)));
                find(num + numbers.charAt(i), cnt+1, numbers);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        
        for(int i=2; i<= (int) Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        
        return true;
    }
}