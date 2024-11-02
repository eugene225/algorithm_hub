class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        for(int i=0; i<4; i++) {
            key = rotateKey(key);
            for(int x=-(lock.length-1); x<(lock.length-1); x++) {
                for(int y=-(lock.length-1); y<(lock.length-1); y++) {
                    if(isFit(key, lock, x, y)) return true;
                }
            }
        }
        
        return false;
    }
    
    private static int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[key.length][key.length];
        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                newKey[i][j] = key[j][key.length-1-i];
            }
        }
        return newKey;
    }
    
    private static boolean isFit(int[][] key, int[][] lock, int x, int y) {
        for(int i=0; i<lock.length; i++) {
            for(int j=0; j<lock.length; j++) {
                if(i+x<0 || i+x>=key.length || j+y<0 || j+y>=key.length) {
                    if(lock[i][j] == 0) return false;
                } else {
                    if(lock[i][j] == key[i+x][j+y]) return false;
                }
            }
        }
        return true;
    }
}