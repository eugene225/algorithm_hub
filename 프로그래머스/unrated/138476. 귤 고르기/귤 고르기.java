import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }

//        for(int key : map.keySet()){
//            System.out.println(key+" "+map.get(key)+" ");
//        }
//        System.out.println();

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for(int val: keys){
            if(k<=0) break;
            answer++;
            k -= map.get(val);
        }

        return answer;
    }
}