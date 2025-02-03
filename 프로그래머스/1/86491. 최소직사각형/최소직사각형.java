class Solution {
    public int solution(int[][] sizes) {
        int max_wid = 0;
        int max_len = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int width = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
            int length = sizes[i][0] > sizes[i][1] ? sizes[i][1] : sizes[i][0];
            
            max_wid = max_wid < width ? width : max_wid;
            max_len = max_len < length ? length : max_len;
        }
        
        return max_wid*max_len;
    }
}