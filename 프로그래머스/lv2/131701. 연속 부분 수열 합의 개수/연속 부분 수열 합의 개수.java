import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        int[] ar = new int[elements.length*2];
        for(int i=0;i< elements.length;i++){
            ar[i] = ar[i+ elements.length] = elements[i];
        }


        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                set.add(Arrays.stream(ar, j, j+i).sum());
            }
        }

        answer = set.size();
        
        return answer;
    }
}