import java.io.*;

class Solution {
    public int solution(int n) throws IOException {
        int answer = 0;
    
        answer = fib(n);
        
        return answer;
    }
    
    public static int fib(int n) {
        int[] ar = new int[n+1];
        
        ar[0] = 0;
        ar[1] = 1;
        
        for(int i=2; i<=n; i++) {
            ar[i] = (ar[i-1] + ar[i-2]) %1234567;
        }
        
        return ar[n]%1234567;
    }
}