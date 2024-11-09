import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static HashSet<String> visited;
    
    private static int ans = 0;
    
	public static void main(String args[]) throws Exception
	{
		int T;
		T=Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] ar = br.readLine().split(" ");
           
            String num =ar[0];
            int cnt = Integer.parseInt(ar[1]);
            
            ans = 0;
            visited = new HashSet<>();
            change(num, cnt);
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        System.out.print(sb.toString());
	}
    
    private static void change(String num, int cnt) {
    	if(cnt == 0) {
            ans = Math.max(ans, Integer.parseInt(num));
            //System.out.println("num : " + num + " / ans : " + ans);
            return;
        }
        
        String currentState = num + "," + cnt;
        if (visited.contains(currentState)) return;
        visited.add(currentState);
        
        char[] nums = num.toCharArray();
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                char tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                int newNum = Integer.parseInt(new String(nums));
                int curNum = Integer.parseInt(num);
                change(String.valueOf(newNum), cnt-1);
                
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }	
    }
}
