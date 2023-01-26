import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;

        int ar[] = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            ar[i] = Integer.parseInt(numbers.substring(i, i+1));
        }

        Arrays.sort(ar);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1;i<= numbers.length();i++){
            boolean visited[] = new boolean[ar.length];
            find(ar, arrayList, i, 0, "", visited);
        }

        answer = arrayList.size();

        return answer;
    }

    public static boolean isPrime(int n){
        for(int i=2; i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void find(int[] ar, ArrayList<Integer> arrayList, int n, int cnt, String str, boolean[] visited){ // n자리 소수 찾기 + cnt 재귀 횟수
        if(cnt==n){
            int num = Integer.parseInt(str);
            if(isPrime(num) && num != 1 && num != 0 && !arrayList.contains(num)) {
                arrayList.add(Integer.parseInt(str));
                //System.out.println(num);
            }
            return;
        }

        for(int i=0;i<ar.length;i++){
            String s = String.valueOf(ar[i]);
            if(cnt==0 && s=="0") continue;

            if(!visited[i]) {
                visited[i] = true;
                find(ar, arrayList, n, cnt + 1, str + s, visited);
                visited[i] = false;
            }
        }
    }
}