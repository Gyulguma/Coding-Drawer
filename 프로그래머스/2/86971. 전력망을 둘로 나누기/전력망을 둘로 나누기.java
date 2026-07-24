import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        int[][] map = new int[n+1][n+1];
        for(int[] wire : wires) {
            map[wire[0]][wire[1]] = 1;
            map[wire[1]][wire[0]] = 1;
        }
        
        for(int[] wire : wires) {
            int count = bfs(map, wire, n);
            int result = Math.abs(count - (n-count));
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
    
    private int bfs(int[][] map, int[] wire, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(wire[0]);
        visited[wire[0]] = true;
        
        int count = 0;
        while(!q.isEmpty()) {
            int current = q.poll();
            count++;
            
            for(int i=1; i<=n; i++) {
                if(map[current][i] == 0 || visited[i]) continue;
                if(current == wire[0] && i == wire[1]) continue;
                if(current == wire[1] && i == wire[0]) continue;
                
                q.offer(i);
                visited[i] = true;
            }
        }
        
        return count; 
    }
}