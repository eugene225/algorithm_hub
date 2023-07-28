class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(int i=0; i<=d; i+=k) {
            long c = (long) d * d;
            long a = (long) i * i;
            int b = (int) Math.sqrt(c - a);

            answer += (b/k) + 1;
        }

        return answer;
    }
}