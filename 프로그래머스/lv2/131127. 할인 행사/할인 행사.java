import java.util.*;

class Solution {
    
    final static int DISCOUNT_DAY = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        List<String> wantList = new ArrayList<>();
        for(int i=0;i<want.length;i++) {
            while(number[i]-->0) {
                wantList.add(want[i]);
            }
        }
        
        for(int i=0;i<discount.length - DISCOUNT_DAY + 1; i++) {
            List<String> buyList = new ArrayList<>(wantList);
            
            for(int j=i; j<DISCOUNT_DAY+i; j++) {
                if(!buyList.contains(discount[j])) continue;
                if(buyList.contains(discount[j])) buyList.remove(discount[j]);
            }
            
            answer += buyList.size() == 0 ? 1 : 0;
        }
        
        return answer;
    }
}