class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        if(n>s) {
            answer = new int[] {-1};
            return answer;
        }
        
        int num = s/n;
        int re = s%n;
        
        answer = new int[n];
        for(int i=0;i<n;i++) answer[i] = num;
        
        int idx = n-1;
        for(int i=0;i<re;i++) {
            answer[idx]++;
            idx--;
        }
        
        return answer;
    }
}