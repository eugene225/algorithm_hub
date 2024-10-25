import java.util.*;

class Solution {
    
    private static Map<Integer, Integer> map;
    
    public int solution(int[] citations) {
        int answer = 0;
        
        map = new HashMap<Integer, Integer>();
        for(int i=1; i<=citations.length; i++) {
            addToMap(i, citations[i-1]);
            //System.out.println(map);
        }
        
        //System.out.println(map);
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int key = iter.next();
            int value = map.get(key);
            
            //System.out.println(value + " " + answer);
            if(key <= value && value != answer) {
                answer = Math.max(key, answer);
            }
        }
        return answer;
    }
    
    private void addToMap(int idx, int cnt) {
        for(int i=1; i<=cnt; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }
}