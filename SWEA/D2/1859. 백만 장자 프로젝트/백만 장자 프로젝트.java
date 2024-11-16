import java.util.*;
import java.io.*;

class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
	public static void main(String args[]) throws Exception
	{
	
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = Integer.parseInt(br.readLine());
            int[] ar = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();
            
            long ans = find(N, ar);
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        
        System.out.print(sb);
	}
    
    private static long find(int N, int[] ar) {
        long profit = 0;
        int maxPrice = 0;  // 현재까지의 최고 매매가
        
        for (int i = N - 1; i >= 0; i--) {
            if (ar[i] > maxPrice) {
                maxPrice = ar[i];
            } else {
                profit += maxPrice - ar[i];
            }
        }
        
        return profit;
    }
}