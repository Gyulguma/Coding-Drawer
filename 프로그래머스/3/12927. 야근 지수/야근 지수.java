import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0; 
        if(works.length == 1) return works[0] - n > 0 ? works[0]-n : 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int work : works) pq.offer(work);
        
        while(n > 0) {
            int work = pq.poll();
            if(work == 0) return 0;
            
            int target = pq.peek() > 0 ? pq.peek() - 1 : 0;
            int dif = work - target;
            
            if(n >= dif) {
                work -= dif;
                n -= dif;
                pq.offer(work);
                continue;
            }
            
            work -= n;
            n = 0;
            pq.offer(work);
        }
        
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}