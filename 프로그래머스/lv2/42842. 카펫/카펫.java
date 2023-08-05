class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int flag = -1;
        for(int i=3;; i++) {
            for(int j=3;; j++) {
                if(i<j) break;
                if((i-2)*(j-2) == yellow && (i-2) + (j-2) == (brown-4)/2){
                    answer[0] = i;
                    answer[1] = j;
                    flag = 1;
                    break;
                }
            }
            if(flag==1) break;
        }
        return answer;
    }
}