import java.util.*;

class Solution {
    
    private static Map<Integer, Map<String, Integer>> map;  
    private static int cnt;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        map = new HashMap<>();
        
        for(int i=0; i<routes.length; i++) {
            int[] route = routes[i];
            
            cnt = 0;
            for(int j=1; j<route.length; j++) {
                int[] start = points[route[j-1]-1];
                int[] end = points[route[j]-1];
                if(j==1) addToMap(start[0], start[1]);
            
                go(start, end);
            }
        }
        
        for (int idx : map.keySet()) {
            Map<String, Integer> innerMap = map.get(idx);
            for (int count : innerMap.values()) {
                answer += count > 1 ? 1 : 0;
            }
        }
        
        return answer;
    }
    
    private static void go(int[] start, int[] end) {
        int now_x = start[0];
        int now_y = start[1];
        
        while(now_x != end[0]) {
            if(now_x > end[0]) {
                now_x -= 1;
            } else {
                now_x += 1;
            }
            cnt+=1;
            addToMap(now_x, now_y);
        }
        
        while(now_y != end[1]) {
            if(now_y > end[1]) {
                now_y -= 1;
            } else {
                now_y += 1;
            }
            cnt+=1;
            addToMap(now_x, now_y);
        }
    }
    
    private static void addToMap(int now_x, int now_y) {
        Map<String, Integer> innerMap = map.getOrDefault(cnt, new HashMap<>());
        
        String key = now_x + "," + now_y;
        
        innerMap.put(key, innerMap.getOrDefault(key, 0) + 1);
        
        map.put(cnt, innerMap);
        //System.out.println("cnt : " + cnt + " "+map.get(cnt));
    }
    
}