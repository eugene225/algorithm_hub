import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            int a = path[0], b = path[1], w = path[2];
            graph.get(a).add(new int[]{b, w});
            graph.get(b).add(new int[]{a, w});
        }

        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        for (int gate : gates) gateSet.add(gate);
        for (int summit : summits) summitSet.add(summit);

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        for (int gate : gates) {
            pq.offer(new int[]{gate, 0});
            intensity[gate] = 0;
        }

        int bestSummit = -1;
        int minIntensity = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currIntensity = current[1];
            
            if (currIntensity > intensity[node]) continue;

            if (summitSet.contains(node)) {
                if (currIntensity < minIntensity || 
                   (currIntensity == minIntensity && node < bestSummit)) {
                    bestSummit = node;
                    minIntensity = currIntensity;
                }
                continue;
            }

            if (gateSet.contains(node) && currIntensity > intensity[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newIntensity = Math.max(currIntensity, weight);

                if (newIntensity < intensity[nextNode]) {
                    intensity[nextNode] = newIntensity;
                    pq.offer(new int[]{nextNode, newIntensity});
                }
            }
        }

        return new int[]{bestSummit, minIntensity};
    }
}
