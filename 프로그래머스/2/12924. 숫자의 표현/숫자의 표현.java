class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1;
        int right = 1;
        
        int current = 1;
        
        while(left <= right && right <= n) {
            if(current > n) {
                current -= left;
                left++;
                continue;
            }
            
            if(current == n) answer++;
            right++;
            current += right;
        }
        
        return answer;
    }
}