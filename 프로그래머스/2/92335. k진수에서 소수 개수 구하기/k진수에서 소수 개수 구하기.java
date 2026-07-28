import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String nums = Integer.toString(n, k);
        System.out.println(nums);
        
        for(String num : nums.split("0")) {
            // num = num.trim();
            // if(num.length() == 0) continue;
            if("".equals(num)) continue;
            // System.out.println(num+":"+isPrime(Integer.parseInt(num)));
            if(isPrime(Long.parseLong(num))) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if(num < 2) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}