import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        boolean isBlank = true;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isBlank && c >= 'a' && c <= 'z') {
                c -= 32;
            }
            answer += c;
            if(c == ' ') isBlank = true;
            else isBlank = false;
        }
        
        return answer;
    }
}