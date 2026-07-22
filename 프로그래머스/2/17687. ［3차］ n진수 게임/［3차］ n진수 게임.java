//0 2 4 6
import java.util.*;

class Solution {
    private char[] num = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        list.add('0');
        int number = 1;
        
        while(list.size() < t*m) {
            for(char c : change(number++, n).toCharArray()) list.add(c);
        }
        
        for(int i=0; i<t; i++) {
            answer += list.get(i*m + (p-1));
        }
        
        return answer;
    }
    
    private String change(int number, int target) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        
        while(number > 0) {
            int idx = number%target;
            sb.append(num[idx]);
            number /= target;
        }
        
        return sb.reverse().toString();
    }
}