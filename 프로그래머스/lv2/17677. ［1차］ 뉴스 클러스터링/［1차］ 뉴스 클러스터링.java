import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> ar1 = new ArrayList<>();
        ArrayList<String> ar2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0;i<str1.length()-1; i++) {
            String tmp1 = str1.substring(i, i+2);
            if(isAlpha(tmp1.charAt(0)) && isAlpha(tmp1.charAt(1))) {
                ar1.add(tmp1);
            }
        }
        
        for(int i=0;i<str2.length()-1; i++) {
            String tmp2 = str2.substring(i, i+2);
            if(isAlpha(tmp2.charAt(0)) && isAlpha(tmp2.charAt(1))) {
                ar2.add(tmp2);
            }
        }
        
        Collections.sort(ar1);
        Collections.sort(ar2);
        
        for(String s : ar1) {
            if(ar2.remove(s)) inter.add(s);
            union.add(s);
        }
        
        for(String s : ar2) {
            union.add(s);
        }
        
        double jakard = 0;
        if(union.size() == 0) jakard = 1;
        else jakard = (double)inter.size()/(double)union.size();
        
        answer = (int)(jakard*65536);
        
        return answer;
    }
    
    public boolean isAlpha(char ch) {
        if(ch >= 'a' && ch <= 'z') return true;
        else return false;
    }
}