import java.util.*;

class Solution {
    
    List<HashSet<String>> graph;  // 각 속성의 유일성을 저장하는 리스트
    boolean[] isUnique;           // 속성이 유일한지 여부를 저장
    List<Set<Integer>> candidateKeys;  // 후보 키 집합을 저장
    
    public int solution(String[][] relation) {
        int answer = 0;
        int row_len = relation[0].length;
        int column_len = relation.length;

        graph = new ArrayList<>();
        candidateKeys = new ArrayList<>();
        
        isUnique = new boolean[row_len];
        
        for(int i = 0; i < row_len; i++) {
            HashSet<String> set = new HashSet<>();
            isUnique[i] = true;
            for(int j = 0; j < column_len; j++) {
                if(!set.add(relation[j][i])) {
                    isUnique[i] = false;
                    break;
                }
            }
            if (isUnique[i]) {
                candidateKeys.add(Set.of(i));
            }
        }

        for(int i = 2; i <= row_len; i++) {
            boolean[] used = new boolean[row_len];
            findCandidateKeys(0, i, used, relation);
        }
        
        answer = candidateKeys.size();
        return answer;
    }
    
    private void findCandidateKeys(int start, int count, boolean[] used, String[][] relation) {
        if (count == 0) {
            Set<Integer> combination = new HashSet<>();
            for (int i = 0; i < used.length; i++) {
                if (used[i]) combination.add(i);
            }
            if (isUniqueSet(combination, relation) && isMinimal(combination)) {
                candidateKeys.add(combination);
            }
            return;
        }
        
        for(int i = start; i < used.length; i++) {
            if (isUnique[i]) continue;
            used[i] = true;
            findCandidateKeys(i + 1, count - 1, used, relation);
            used[i] = false;
        }
    }

    // 주어진 속성 조합이 유일성을 만족하는지 확인하는 메서드
    private boolean isUniqueSet(Set<Integer> combination, String[][] relation) {
        Set<String> set = new HashSet<>();
        for(String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for(int i : combination) {
                key.append(row[i]).append(",");
            }
            if (!set.add(key.toString())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isMinimal(Set<Integer> combination) {
        for (Set<Integer> key : candidateKeys) {
            if (combination.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
}
