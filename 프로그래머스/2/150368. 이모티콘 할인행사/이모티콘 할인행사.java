import java.util.*;

class Solution {
    private static int ans1;
    private static int ans2;
    
    public int[] solution(int[][] users, int[] emoticons) {        
        ans1 = 0; ans2 = 0;
        
        List<int[]> list = new ArrayList<>();
        for(int i=10; i<=40; i+=10){
            int emoticonValue = calculateEmoticon(emoticons, 0, i);
            list.add(new int[]{emoticonValue, i});
            dfs(users, emoticons, list, 1);
            list.remove(list.size()-1);
        }
        
        return new int[]{ans1, ans2};
    }
    
    private static void dfs(int[][] users, int[] emoticons, List<int[]> list, int idx) {
        if(idx == emoticons.length) {
            // for(int i=0; i<list.size(); i++) {
            //     System.out.print(i + ": " + list.get(i)[0] + ", ");
            // }
            // System.out.println();
            calculate(list, users);
            return;
        }
        
        for(int i=10; i<=40; i+=10) {
            int emoticonValue = calculateEmoticon(emoticons, idx, i);
            list.add(new int[]{emoticonValue, i});
            dfs(users, emoticons, list, idx+1);
            list.remove(list.size()-1);
        }
        
    }
    
    private static int calculateEmoticon(int[] emoticons, int idx, int percent) {
        return (int) emoticons[idx] * (100 - percent) / 100;
    }
    
    private static void calculate(List<int[]> list, int[][] users) {
        int total = 0;
        int plusCnt = 0;
        
        for(int[] person: users) {
            int userPer = person[0];
            int userCost = person[1];
            //System.out.println("userPer : " + userPer + ", userCost : " + userCost);
            
            int sum = 0;
            for(int i=0; i<list.size(); i++) {
                int[] emo = list.get(i);
                if(emo[1] >= userPer) {
                    sum += emo[0];
                    //System.out.println("list : " + emo + ", sum : " + sum + ", plusCnt : " + plusCnt);
                }
                if(sum >= userCost) {
                    //System.out.println("sum : " + sum + ", plusCnt : " + plusCnt);
                    plusCnt++;
                    sum = 0;
                    break;
                }
            }
            total += sum;
        }
        
        if((ans1 == plusCnt && ans2 < total) || ans1 < plusCnt) {
            ans1 = plusCnt;
            ans2 = total;
            //System.out.println("total : " + total + ", plusCnt : " + plusCnt);
        }
    }
}