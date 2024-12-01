class Solution {
    public int[] solution(int[] sequence, int k) {
        int l = 0, r = 0;
        int sum = sequence[0];
        int[] answer = {-1, -1};
        int minLength = Integer.MAX_VALUE;
        
        while (r < sequence.length) {
            if (sum == k) {
                if ((r - l + 1) < minLength) {
                    answer = new int[]{l, r};
                    minLength = r - l + 1;
                }
                sum -= sequence[l];
                l++;
            } else if (sum < k) {
                r++;
                if (r < sequence.length) sum += sequence[r];
            } else {
                sum -= sequence[l];
                l++;
            }
        }
        
        return answer;
    }
}
