import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> countMap = new HashMap<>();

        for (int weight : weights) {
            countMap.put(weight, countMap.getOrDefault(weight, 0L) + 1);
        }

        for (int weight : countMap.keySet()) {
            long count = countMap.get(weight);

            answer += count * (count - 1) / 2;

            if (countMap.containsKey(weight * 2)) {
                answer += count * countMap.get(weight * 2);
            }
            if (weight % 2 == 0 && countMap.containsKey(weight * 3 / 2)) {
                answer += count * countMap.get(weight * 3 / 2);
            }
            if (weight % 3 == 0 && countMap.containsKey(weight * 4 / 3)) {
                answer += count * countMap.get(weight * 4 / 3);
            }
        }
        return answer;
    }
}
