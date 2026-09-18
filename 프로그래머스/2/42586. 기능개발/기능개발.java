import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int work = 100 - progresses[i];
            int period = work/speeds[i];
            if(work%speeds[i] > 0) period++;
            q.offer(period);
        }
        
        int count = 1;
        int pre = q.poll();
        while(!q.isEmpty()) {
            int work = q.poll();
            
            if(work <= pre) {
                count++;
                continue;
            }
            
            result.add(count);
            count = 1;
            pre = work;
        }
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}