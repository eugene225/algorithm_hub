import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> list = new ArrayList<>();

        boolean flag = true;

        for(int i=0;i< words.length; i++) {

            // 맨 뒷글자와 맨 앞글자가 다른 경우
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || list.contains(words[i])) {
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }

            list.add(words[i]);

        }

        if(flag) return new int[] {0,0};
        return answer;
    }
}