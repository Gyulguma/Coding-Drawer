import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i< operations.length;i++){
            String[] operation = operations[i].split(" ");
            String operator = operation[0];
            int operand = Integer.parseInt(operation[1]);
            if(operator.equals("I")){
                minPq.add(operand);
                maxPq.add(operand);
            }
            else if(operator.equals("D")){
                if(maxPq.isEmpty()) continue;
                if(operand == 1){
                    int max = maxPq.poll();
                    minPq.remove(max);
                } else if(operand == -1){
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }
        if(maxPq.isEmpty()){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        return answer;
    }
}