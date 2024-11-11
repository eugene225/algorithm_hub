import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] ar = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            Set<Integer> set = new HashSet<>();
            set.add(0); // Initialize with 0 score
            
            for (int num : ar) {
                Set<Integer> newScores = new HashSet<>();
                for (int score : set) {
                    newScores.add(score + num);
                }
                set.addAll(newScores);
            }
            
            sb.append("#").append(test_case).append(" ").append(set.size()).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
