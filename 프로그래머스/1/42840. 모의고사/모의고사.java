import java.util.*;

class Solution {
    
    private int[] p1 = {1,2,3,4,5};
    private int[] p2 = {2,1,2,3,2,4,2,5};
    private int[] p3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<>();
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for(int i=0; i<answers.length; i++) {
            if(p1[i%5] == answers[i]) cnt1++;
            if(p2[i%8] == answers[i]) cnt2++;
            if(p3[i%10] == answers[i]) cnt3++;
        }
        
        int max = Math.max(Math.max(cnt1, cnt2), cnt3);
        
        if(cnt1 == max) ans.add(1);
        if(cnt2 == max) ans.add(2);
        if(cnt3 == max) ans.add(3);
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}