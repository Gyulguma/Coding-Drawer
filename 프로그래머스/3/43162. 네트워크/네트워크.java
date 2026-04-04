import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        for(int start = 0; start<n; start++){
            if(visited[start]) continue;
            
            q.offer(start);
            visited[start] = true;

            while(!q.isEmpty()){
                int node = q.poll();

                for(int i=0; i<n; i++){
                    if(computers[node][i] == 0 || visited[i]) continue;
                    q.offer(i);
                    visited[i] = true;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}