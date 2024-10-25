class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String convert = convertToK(n, k);
        
        String[] convert_ar;
        if (convert.contains("0")) {
            convert_ar = convert.split("0");
            for (String number : convert_ar) {
                if (number.equals("")) continue;
                if (isPrime(Long.parseLong(number))) answer++;
            }
        } else {
            if (isPrime(Long.parseLong(convert))) return 1;
            else return 0;
        }
        
        return answer;
    }
    
    private String convertToK(int n, int k) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int remainder = n % k;
            result.insert(0, remainder);
            n /= k;
        }
        return result.toString();
    }
    
    private boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        
        return true;
    }
}
