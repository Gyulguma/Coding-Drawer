import java.util.*;

class Solution {
    private int min = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        
        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<wires.length; i++){
            int[] wire = wires[i];
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        for(int i=0; i<wires.length; i++){
            int[] wire = wires[i];
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;
            
            counting(graph, n);
            
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
         
        return min;
    }
    
    private void counting(int[][] graph, int n){
        int count1 = 0;
        int count2 = 0;
        
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            int count = 0;
            if(visited[i]) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;
            while(!q.isEmpty()){
                int current = q.poll();
                count++;
                for(int j=1; j<=n; j++){
                    if(visited[j] || graph[current][j] == 0) continue;
                    q.offer(j);
                    visited[j] = true;
                }
            }
            if(count1 == 0) count1 = count;
            else count2 = count;
        }
        
        int dif = Math.abs(count1-count2);
        min = Math.min(min, dif);
    }
}