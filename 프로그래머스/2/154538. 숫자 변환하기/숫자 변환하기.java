import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{x, 0});
        boolean[] visited = new boolean[y+1];
        
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int current = info[0];
            int count = info[1];
            
            if(current == y) return count;
            
            if(visited[current]) continue;
            visited[current] = true;
            
            if(current + n <= y && !visited[current + n]) pq.offer(new int[]{current + n, count + 1});
            if(current * 2 <= y && !visited[current * 2]) pq.offer(new int[]{current * 2, count + 1});
            if(current * 3 <= y && !visited[current * 3]) pq.offer(new int[]{current * 3, count + 1});
        }
        
        return -1;
    }
}