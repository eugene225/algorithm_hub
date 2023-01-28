import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> arrayList = new ArrayList<>();
        long fac = 1;
        for(int i=1;i<=n;i++){
            arrayList.add(i);
            fac *= i;
        }

        int idx=0;
        k--;
        while(n > 0){
            fac /= n;
            int val = (int) (k / fac);
            answer[idx++] = arrayList.get(val);
            arrayList.remove(val);

            k %= fac;
            n--;
        }

        return answer;
    }
}