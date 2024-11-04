import java.util.*;

class Solution {
    
    private static String[][] graph;
    private static List<Set<String>> mergeList;
    private static List<String> ans;
    
    public String[] solution(String[] commands) {
        graph = new String[51][51];
        mergeList = new ArrayList<>();
        ans = new ArrayList<>();
        
        for (String command : commands) {
            String[] ar = command.split(" ");
            switch (ar[0]) {
                case "UPDATE":
                    if (ar.length == 4) { // UPDATE r c value
                        update1(ar);
                    } else if (ar.length == 3) { // UPDATE value1 value2
                        update2(ar);
                    }
                    break;
                case "MERGE":
                    merge(ar);
                    break;
                case "UNMERGE":
                    unMerge(ar);
                    break;
                case "PRINT":
                    print(ar);
                    break;
            }
        }
        
        return ans.toArray(new String[0]);
    }
    
    private static void update1(String[] ar) {
        int x = Integer.parseInt(ar[1]);
        int y = Integer.parseInt(ar[2]);
        String value = ar[3];
        String pointStr = x + "," + y;

        for (Set<String> mergeSet : mergeList) {
            if (mergeSet.contains(pointStr)) {
                for (String p : mergeSet) {
                    String[] rc = p.split(",");
                    int r = Integer.parseInt(rc[0]);
                    int c = Integer.parseInt(rc[1]);
                    graph[r][c] = value;
                }
                return;
            }
        }
        graph[x][y] = value;
    }
    
    private static void update2(String[] ar) {
        String value1 = ar[1];
        String value2 = ar[2];
        
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (value1.equals(graph[i][j])) {
                    graph[i][j] = value2;
                }
            }
        }
    }
    
    private static void merge(String[] ar) {
        int r1 = Integer.parseInt(ar[1]);
        int c1 = Integer.parseInt(ar[2]);
        int r2 = Integer.parseInt(ar[3]);
        int c2 = Integer.parseInt(ar[4]);
        String point1 = r1 + "," + c1;
        String point2 = r2 + "," + c2;

        if (point1.equals(point2)) return;

        Set<String> mergeSet1 = null;
        Set<String> mergeSet2 = null;

        for (Set<String> mergeSet : mergeList) {
            if (mergeSet.contains(point1)) mergeSet1 = mergeSet;
            if (mergeSet.contains(point2)) mergeSet2 = mergeSet;
        }
        
        Set<String> updateSet = null;
        if (mergeSet1 != null && mergeSet2 != null && mergeSet1 != mergeSet2) {
            mergeSet1.addAll(mergeSet2);
            mergeList.remove(mergeSet2);
            updateSet = mergeSet1;
        } else if (mergeSet1 != null) {
            mergeSet1.add(point2);
            updateSet = mergeSet1;
        } else if (mergeSet2 != null) {
            mergeSet2.add(point1);
            updateSet = mergeSet2;
        } else {
            Set<String> newSet = new HashSet<>();
            newSet.add(point1);
            newSet.add(point2);
            mergeList.add(newSet);
            updateSet = newSet;
        }

        String value = graph[r1][c1] != null ? graph[r1][c1] : graph[r2][c2];
        for (String point : updateSet) {
            String[] rc = point.split(",");
            graph[Integer.parseInt(rc[0])][Integer.parseInt(rc[1])] = value;
        }
    }
    
    private static void unMerge(String[] ar) {
        int r = Integer.parseInt(ar[1]);
        int c = Integer.parseInt(ar[2]);
        String point = r + "," + c;

        Set<String> targetMergeSet = null;
        for (Set<String> mergeSet : mergeList) {
            if (mergeSet.contains(point)) {
                targetMergeSet = mergeSet;
                break;
            }
        }

        if (targetMergeSet != null) {
            String originalValue = graph[r][c];

            for (String p : targetMergeSet) {
                String[] rc = p.split(",");
                graph[Integer.parseInt(rc[0])][Integer.parseInt(rc[1])] = null;
            }

            graph[r][c] = originalValue;
            mergeList.remove(targetMergeSet);
        }
    }
    
    private static void print(String[] ar) {
        int r = Integer.parseInt(ar[1]);
        int c = Integer.parseInt(ar[2]);
        ans.add(graph[r][c] == null ? "EMPTY" : graph[r][c]);
    }
}
