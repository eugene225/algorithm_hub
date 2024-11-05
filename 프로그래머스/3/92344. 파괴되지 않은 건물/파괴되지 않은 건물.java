class Solution {
    private static int[][] damage;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length;
        damage = new int[row+1][col+1];
        
        for(int[] one: skill) {
            int type = one[0];
            int r1 = one[1]; int c1 = one[2];
            int r2 = one[3]; int c2 = one[4];
            int degree = one[5];
            
            if(type == 1) {
                degree = -degree;
            }
            
            damage[r1][c1] += degree;
            damage[r1][c2+1] -= degree;
            damage[r2+1][c1] -= degree;
            damage[r2+1][c2+1] += degree;
        }
        
        for(int j=0; j<col+1; j++) {
            for(int i=0; i<row; i++) {
                damage[i+1][j] += damage[i][j];
            }
        }
        
        for(int i=0; i<row+1; i++) {
            for(int j=0; j<col; j++) {
                damage[i][j+1] += damage[i][j];
            }
        }
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                board[i][j] += damage[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}