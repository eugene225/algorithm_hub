class Solution {
    public String solution(int n) {
        String answer = "";
        String[] remains = {"4", "1", "2"};
        
        while(n > 0) {
            int tmp = n%3;
            n /= 3;
            
            if(tmp == 0) n--;
            
            answer = remains[tmp] + answer;
        }
        
        return answer;
    }
}