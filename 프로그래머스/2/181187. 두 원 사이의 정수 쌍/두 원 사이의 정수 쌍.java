class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1Pow = (long)Math.pow(r1,2);
        long r2Pow = (long)Math.pow(r2,2);
        long cnt = 0;
        
        for(long x = 0; x <= r2; x++) {
            long y2 = (long)Math.sqrt(r2Pow - x*x);
            long y1 = (long)Math.sqrt(r1Pow - x*x);
            
            if(Math.sqrt(r1Pow-x*x) % 1 == 0) cnt++;
            
            answer += (y2-y1) * 4;
        }
        
        answer += cnt*4;
        answer -= 4;
        
        return answer;
    }
}