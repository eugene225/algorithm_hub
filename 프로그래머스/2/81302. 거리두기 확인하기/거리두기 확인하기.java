class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++) { // 5개의 대기실
            Character place[][] = new Character[5][5];
            for(int j=0; j<5; j++) { // 각 대기실 좌석
                String line = places[i][j];
                for(int k=0; k<5; k++) {
                    place[j][k] = line.charAt(k);
                }
            }
            if(isFar(place)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
    private static boolean isFar(Character[][] place) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(place[i][j] == 'P' && !checkFar(place, i, j)) {
                    //System.out.println(i + " " + j + " false");
                    return false;
                }
            }
        }
        return true;
    }
    
    static int[] dx = {-2, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 2};
    static int[] dy = {0, 1, 0, -1, 2, 1, -1, -2, 1, 0, -1, 0};
    
    private static boolean checkFar(Character[][] place, int x, int y) {
        for(int i=0; i<12; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
            
            if(place[nx][ny] == 'P') {
                if(nx != x && ny != y) { // 대각선
                    if(place[x][ny]!='X' || place[nx][y]!='X') {
                        //System.out.println("0. " + nx + " " + ny);
                        return false;
                    }
                }

                if(Math.abs(dx[i]) == 2) {
                    if(place[x + dx[i]/2][ny] != 'X') {
                        //System.out.println("1. " + nx + " " + ny);
                        return false;
                    }
                } else if (Math.abs(dy[i]) == 2) {
                    if(place[nx][y + dy[i]/2] != 'X') {
                        //System.out.println("2. " + nx + " " + ny);
                        return false;
                    }
                }
                
                if(Math.abs(dx[i]) == 1 && dy[i] ==0 || dx[i] == 0 && Math.abs(dy[i]) == 1) {
                    //System.out.println("3. " + nx + " " + ny);
                    return false;
                }
            }
            
            //System.out.println(nx + " " + ny);
        }
        
        return true;
    }
}