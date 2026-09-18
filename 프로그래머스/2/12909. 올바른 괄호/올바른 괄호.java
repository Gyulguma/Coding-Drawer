import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
                continue;
            }
            if(stack.isEmpty()) return false;
            stack.pop();
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}