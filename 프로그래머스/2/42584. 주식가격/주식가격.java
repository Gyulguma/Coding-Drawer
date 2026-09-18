import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] temp = stack.pop();
                // System.out.println(Arrays.toString(temp)+","+i);
                answer[temp[0]] = i - temp[0];
            }
            stack.push(new int[]{i, prices[i]});
        }
        
        while(!stack.isEmpty()) {
            int[] temp = stack.pop();
            // System.out.println(Arrays.toString(temp)+","+(prices.length-1));
            answer[temp[0]] = prices.length-1 - temp[0];
        }
        return answer;
    }
}