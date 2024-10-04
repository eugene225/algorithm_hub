import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int cutLength = 1; cutLength <= s.length(); cutLength++) {
            answer = Math.min(answer, compressString(cutLength, s));
        }
        
        return answer;
    }
    
    private static int compressString(int cutLength, String s) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < s.length(); i += cutLength) {
            String current = s.substring(i, Math.min(i + cutLength, s.length()));
            String next = (i + cutLength < s.length()) ? s.substring(i + cutLength, Math.min(i + 2 * cutLength, s.length())) : "";

            if (current.equals(next)) {
                count++;
            } else {
                if (count > 1) {
                    compressed.append(count);
                }
                compressed.append(current);
                count = 1;
            }
        }
        
        return compressed.length();
    }
}
