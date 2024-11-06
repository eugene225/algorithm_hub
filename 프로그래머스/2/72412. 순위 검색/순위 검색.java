import java.util.*;

class Solution {
    
    private static Map<String, List<Integer>> scoreMap;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        scoreMap = new HashMap<>();
        
        for (String i : info) {
            String[] parts = i.split(" ");
            int score = Integer.parseInt(parts[4]);
            addToScoreMap(parts, score);
        }
        
        for (String key : scoreMap.keySet()) {
            Collections.sort(scoreMap.get(key));
        }
        
        int index = 0;
        for (String q : query) {
            String[] parts = q.replaceAll(" and ", " ").split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int targetScore = Integer.parseInt(parts[4]);
            
            if (scoreMap.containsKey(key)) {
                List<Integer> scores = scoreMap.get(key);
                answer[index] = binarySearch(scores, targetScore);
            } else {
                answer[index] = 0;
            }
            index++;
        }
        
        return answer;
    }
    
    private void addToScoreMap(String[] parts, int score) {
        String[] langs = { parts[0], "-" };
        String[] types = { parts[1], "-" };
        String[] ages = { parts[2], "-" };
        String[] foods = { parts[3], "-" };
        
        for (String lang : langs) {
            for (String type : types) {
                for (String age : ages) {
                    for (String food : foods) {
                        String key = lang + type + age + food;
                        scoreMap.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                    }
                }
            }
        }
    }
    
    private int binarySearch(List<Integer> scores, int targetScore) {
        int left = 0, right = scores.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return scores.size() - left;
    }
}
