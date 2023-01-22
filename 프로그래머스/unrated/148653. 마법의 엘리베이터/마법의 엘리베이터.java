

class Solution {
    public int solution(int storey) {
        int answer = 0;

        int N = storey;
        String str = String.valueOf(N);
        
        int[] ar = new int[str.length()];
        for(int i=0;i<str.length();i++){
            ar[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for(int i=str.length()-1; i>=0; i--){
            if(ar[i]==10){
                if(i==0) {
                    answer += 1;
                    continue;
                }
                ar[i-1]++;
                continue;
            }
            
            if(ar[i] < 5){
                answer += ar[i];
            }
            else if(ar[i] > 5){
                answer += (10-ar[i]);
                if(i == 0){
                    answer+=1;
                    continue;
                }
                ar[i-1]++;
            }
            else if(ar[i] == 5){
                if(i==0){
                    answer += 5;
                    continue;
                }else{
                    if(ar[i-1] < 5){
                        answer+=ar[i];
                    }else{
                        answer+=5;
                        ar[i-1]++;
                    }
                }
            }
        }

        return answer;
    }
}