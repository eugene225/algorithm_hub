import java.util.*;

class Solution {
    static int ar[][];
    
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        ar = new int[n+1][n+1];

        // 1. 노드 그래프 만들기
        for(int wire[] : wires) {
            int a = wire[0];
            int b = wire[1];

            ar[a][b] = ar[b][a] = 1;  //연결된 노드
        }

        //2. 전선 정보 순회하면서 전선 하나 끊고 둘 중 하나에 대해 bfs 탐색
        for(int wire[] : wires) {
            int a = wire[0];
            int b = wire[1];

            ar[a][b] = ar[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            ar[a][b] = ar[b][a] = 1;
        }

        return answer;
    }

    public static int bfs(int n , int start) {
        boolean visited[] = new boolean[n+1];

        visited[start] = true;
        int cnt=1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int s1 = q.poll();
            visited[s1] = true;

            for(int i=1;i<=n;i++){
                if(visited[i]) continue;
                if(ar[s1][i]==1) {
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}