import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        
        T: for(int i=0; i<s.length(); i++) {
            for(int j=0; j<s.length(); j++) {
                int idx = (i+j) % s.length();
                char c = s.charAt(idx);
                
                if(c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    continue;
                }
                
                if(stack.isEmpty()) continue T;
                if(map.get(c) != stack.peek()) continue T;
                stack.pop();
            }
            
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}