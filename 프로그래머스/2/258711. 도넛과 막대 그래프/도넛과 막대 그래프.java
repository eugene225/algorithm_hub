import java.util.*;

class Solution {
    
    public int[] solution(int[][] edges) {
        Map<Integer,Integer> out = new HashMap<>(); // <Node, Count>
        Map<Integer,Integer> in = new HashMap<>();
        
        int gen = -1;
        int doughnut = 0;
        int stick = 0;
        int eight = 0;

        for(int [] e : edges){
            out.put(e[0],out.getOrDefault(e[0],0) + 1);
            in.put(e[1],in.getOrDefault(e[1],0) + 1);
        }
        
        for(int node : out.keySet()){
            if(out.get(node) > 1) {
                if(!in.containsKey(node)) gen = node;
                else eight++;
            }
        }
        
        for(int node : in.keySet()){
            if(!out.containsKey(node)) stick++;
        }
        
        doughnut = out.get(gen) - stick - eight;

        return new int[] {gen,doughnut,stick,eight};
    }
}