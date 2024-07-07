import java.util.*;

class Solution {
    
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private static final ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        generateWords("", 0);
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    private static void generateWords(String current, int depth) {
        if(current.length() > 0 && current.length() <=5) {
            list.add(current);
        } else if (depth > 5) {
            return;
        }
        
        for(char c : VOWELS) {
            generateWords(current + c, depth+1);
        }
    }
}