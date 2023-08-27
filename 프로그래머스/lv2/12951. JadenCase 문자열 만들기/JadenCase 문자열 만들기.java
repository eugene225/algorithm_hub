class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++) {
            if(i==0 || s.charAt(i-1)==' ') {
                if(isAlpha(s.charAt(i))) {
                    answer += (char)('A' + s.charAt(i)-'a');
                }
                else answer += s.charAt(i);
            }
            else answer += s.charAt(i);
        }
        
        return answer;
    }
    
    public boolean isAlpha(char ch) {
        if(ch>='a' && ch<='z') {
            return true;
        }
        return false;
    }
}