class Solution {
    public int solution(String[] board) {
        int answer = 1;
        
        int xCnt = 0;
        int oCnt = 0;
        
        int sumICnt[][] = new int[3][2];
        int sumJCnt[][] = new int[2][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j) == 'O') {
                    oCnt++;
                    sumICnt[i][0]++;
                    sumJCnt[0][j]++;
                }
                else if(board[i].charAt(j) == 'X') {
                    xCnt++; 
                    sumICnt[i][1]++;
                    sumJCnt[1][j]++;
                }
            }
        }
        
        if(xCnt > oCnt) return 0;
        else if(Math.abs(oCnt - xCnt) > 1) {
            return 0;
        }
        else if(xCnt == oCnt) {
            if(checkEnd(board, sumICnt, sumJCnt, 'O')) return 0;
        } else if(oCnt - xCnt == 1 && checkEnd(board, sumICnt, sumJCnt, 'X')) {
            return 0;
        }
        
        return answer;
    }
    
    private static boolean checkEnd(String[] board, int[][] sumICnt, int[][] sumJCnt, char ch) {
        for(int i=0; i<3; i++) {
            if(ch == 'O') {
                if(sumICnt[i][0] == 3 || sumJCnt[0][i] == 3) return true;
            }
            if(ch == 'X') {
                if(sumICnt[i][1] == 3 || sumJCnt[1][i] == 3) return true;
            }
        }
        
        if(ch == board[1].charAt(1)) {
            if(ch == board[0].charAt(0) && ch == board[2].charAt(2)) return true;
            if(ch == board[2].charAt(0) && ch == board[0].charAt(2)) return true;
        }
        
        return false;
    }
}