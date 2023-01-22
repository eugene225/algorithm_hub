import java.util.*;

class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col-1]==o2[col-1]){
                    return o2[0]-o1[0];
                }
                return o1[col-1] - o2[col-1];
            }
        });

//        for(int i=0;i<data.length;i++){
//            for(int j=0;j<data[0].length;j++){
//                System.out.print(data[i][j]+" ");
//            }
//            System.out.println();
//        }

        int S[] = new int[data.length];
        for(int i=row_begin-1; i<=row_end-1; i++){
            for(int j=0;j<data[0].length;j++){
                S[i] += data[i][j]%(i+1);
            }
            //System.out.println("S["+i+"]:"+S[i]);
        }

        answer = S[row_begin-1];
        for(int i=row_begin;i<=row_end-1;i++){
            answer ^= S[i];
        }

        return answer;
    }
}