import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = Arrays.stream(numbers)
                                 .mapToObj(String::valueOf)
                                 .toArray(String[]::new);
        
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder answer = new StringBuilder();
        for (String numStr : numStrs) {
            answer.append(numStr);
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}
