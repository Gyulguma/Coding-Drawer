import java.util.*;

class Solution {
    private int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[n][m];

        pq.offer(new int[]{0,0,1});
        
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int x = info[0];
            int y = info[1];
            int count = info[2];
            
            if(visited[x][y]) continue;
            visited[x][y] = true;
            
            if(x == n-1 && y == m-1){
                return count;
            }
            
            for(int i=0; i<d.length; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                
                pq.offer(new int[]{nx, ny, count+1});
            }
            
        }
        
        
        return -1;
    }
}