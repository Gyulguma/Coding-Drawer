import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                continue;
            }
            stack.push(cur);
        }
        
        if(stack.size() == 0) return 1;
        return 0;
    }
}