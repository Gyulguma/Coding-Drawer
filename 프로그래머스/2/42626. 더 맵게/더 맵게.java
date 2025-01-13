import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            minHeap.offer(scoville[i]);
        }
        
        while(minHeap.peek() < K){
            if(minHeap.size() < 2) return -1;
            
            int frist = minHeap.poll();
            int second = minHeap.poll();
            minHeap.offer(frist + second*2);
            answer++;
        }
        
        return answer;
    }
}