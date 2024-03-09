import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> queueF = new LinkedList<>();
        Queue<Integer> queueS = new LinkedList<>();
        long totalA=0, totalB = 0;
        for(int i=0; i<queue1.length; i++){
            queueF.add(queue1[i]);
            queueS.add(queue2[i]);
            totalA += queue1[i];
            totalB += queue2[i];
        }
        long total = totalA + totalB;
        if(total%2 != 0) return -1;

        while(totalA != totalB){
            if(queueF.isEmpty() || queueS.isEmpty()){
                return -1;
            }
            if(answer >= (queue1.length+queue2.length)*2) {
                return -1;
            }
            if(totalA > totalB){
                int temp = queueF.poll();
                totalA -= temp;
                queueS.add(temp);
                totalB += temp;
                answer++;
            }
            else if(totalB > totalA){
                int temp = queueS.poll();
                totalB -= temp;
                queueF.add(temp);
                totalA += temp;
                answer++;
            }
        }

        return answer;
    }
}