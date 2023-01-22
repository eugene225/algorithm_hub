import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> Del = new Stack<>();
        Stack<Integer> Pick = new Stack<>();
        int now;

        for(int i=0;i<n;i++){
            if(deliveries[i]>0) {
                Del.add(i);
            }
        }

        for(int i=0;i<n; i++) {
            if(pickups[i]>0) {
                Pick.add(i);
            }
        }

        while(!Del.isEmpty() || !Pick.isEmpty()){
            if(!Del.isEmpty() && !Pick.isEmpty()) answer += Math.max((Del.peek()+1)*2, (Pick.peek()+1)*2);
            else if(!Del.isEmpty()) answer += (Del.peek()+1)*2;
            else if(!Pick.isEmpty()) answer += (Pick.peek()+1)*2;

            now = 0;
            while(!Del.isEmpty()){
                if(deliveries[Del.peek()] + now <= cap){
                    now += deliveries[Del.pop()];
                }else{
                    deliveries[Del.peek()] -= (cap-now);
                    break;
                }
            }

            now = 0;
            while(!Pick.isEmpty()){
                if(pickups[Pick.peek()] + now <= cap){
                    now += pickups[Pick.pop()];
                }else{
                    pickups[Pick.peek()] -= (cap-now);
                    break;
                }
            }
        }

        return answer;
    }
}