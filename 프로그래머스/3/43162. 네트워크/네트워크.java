import java.util.*;

class Solution {
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            bfs(i, computers);
            answer++;
        }
        
        return answer;
    }
    
    private void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            for(int i=0; i<computers[current].length; i++) {
                if(computers[current][i] == 0 || visited[i]) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}