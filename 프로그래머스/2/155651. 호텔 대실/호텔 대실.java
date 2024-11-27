class Solution {
    private static int[] graph;
    public int solution(String[][] book_time) {
        int answer = 0;
        
        graph = new int[1451];
        for(String[] ar : book_time) {
            int start = toMin(ar[0].split(":"));
            int end = toMin(ar[1].split(":"));
            
            graph[start]++;
            graph[end+10]--;
        }
        
        for(int i=1; i<graph.length; i++) {
            graph[i] += graph[i-1];
            answer = Math.max(answer, graph[i]);
        }
        return answer;
    }
    
    private static int toMin(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}