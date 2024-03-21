class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        for(int i=1; i<=s.length(); i++) {
            int max = checkString(s, i);
            answer = max > answer ? max : answer;
        }

        return answer;
    }
    
    private int checkString(String s, int length) {
        for(int i=0; i<=s.length()-length; i++) {
            int start = i;
            int end = i + length - 1;
            if(isPalindrome(s, start, end)) {
                return length;
            }
        }
        return 0;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        int length = end-start+1;
        for(int i=start; i<start + length/2; i++) {
            if(s.charAt(i) != s.charAt(end-(i-start))) return false;
        }
        return true;
    }
}