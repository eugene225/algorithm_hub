import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = (picks[0] + picks[1] + picks[2]) * 5;

        int len = Math.min(minerals.length, totalPicks);
        int[][] fatigue = new int[(len + 4) / 5][3];

        for (int i = 0; i < len; i++) {
            String mineral = minerals[i];
            int index = i / 5;
            
            if (mineral.equals("diamond")) {
                fatigue[index][0] += 1;
                fatigue[index][1] += 5;
                fatigue[index][2] += 25;
            } else if (mineral.equals("iron")) {
                fatigue[index][0] += 1;
                fatigue[index][1] += 1;
                fatigue[index][2] += 5;
            } else if (mineral.equals("stone")) {
                fatigue[index][0] += 1;
                fatigue[index][1] += 1;
                fatigue[index][2] += 1;
            }
        }

        Arrays.sort(fatigue, (a, b) -> b[2] - a[2]);

        for (int[] group : fatigue) {
            if (picks[0] > 0) {
                answer += group[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += group[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += group[2];
                picks[2]--;
            }
        }
        return answer;
    }
}
