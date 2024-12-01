import java.util.*;

class Solution {
    
    private static HashMap<String, String> map;
    
    public String[] solution(String[] record) {
        String[] answer = {};
        
        map = new HashMap<>();        
        for(String str : record) {
            String[] ar = str.split(" ");
            //System.out.println(ar[0] + " " + ar[1]);
            if(ar.length == 3) map.put(ar[1], ar[2]);
        }
        
        //System.out.println(map);
        
        List<String> ans = new ArrayList<>();
        for(String str : record) {
            String[] ar = str.split(" ");
            if(ar[0].equals("Enter")) {
                ans.add(map.get(ar[1]) + "님이 들어왔습니다.");
            }else if(ar[0].equals("Leave")) {
                ans.add(map.get(ar[1]) + "님이 나갔습니다.");
            }
        }
        
        //System.out.println(ans);
        
        return ans.toArray(new String[0]);
    }
}