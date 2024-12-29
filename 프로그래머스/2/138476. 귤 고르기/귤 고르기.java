import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : tangerine) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies, Collections.reverseOrder());
        
        int uniqueCount = 0;
        for (int freq : frequencies) {
            if (k <= 0) break;
            k -= freq;
            uniqueCount++;
        }
        
        return uniqueCount;
    }
}
