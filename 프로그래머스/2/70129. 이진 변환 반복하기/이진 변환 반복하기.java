import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[2];
        
        while(!s.equals("1")) {
            int zero = 0;
            
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') zero++;
            }
            
            s = Integer.toBinaryString(s.length() - zero);
            result[0]++;
            result[1] += zero;
        }
        return result;
    }
}