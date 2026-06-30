import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 1;
        while(n > 1) {
            if(n%2 != 0) answer++;
            n /= 2;
        }
        
        return answer;
    }
}