class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int map = brown + yellow;
        
        for(int i=3; i<=map; i++) {
            int col = i;
            int row = map/col;
            
            if(row < 3) continue;
            
            if(row >= col) {
                if((row-2) * (col-2) == yellow) {
                    answer = new int[]{row, col};
                    break;
                }
            }
        }
        
        return answer;
    }
}