import java.util.*;

class Solution {
    private int[][] d = {{0,-1},{0,1},{1,0},{-1,0}};
    private int n = 101;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        
        int[][] map = new int[n][n];
        for(int[] target : rectangle) {
            paint(map, target);
        }
        for(int[] target : rectangle) {
            delete(map, target);
        }
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++){
        //         if(map[i][j] == 0) System.out.print(' ');
        //         else System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0];
            int y = info[1];
            int count = info[2];
            
            if(x == itemX*2 && y == itemY*2) {
                answer = Math.min(answer, count/2);
                continue;
            }
            
            for(int i=0; i<d.length; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(map[nx][ny] == 0 || visited[nx][ny]) continue;
                
                q.offer(new int[]{nx, ny, count+1});
                visited[nx][ny] = true;
            }
        }
        
        return answer;
    }
    int num = 1;
    private void paint(int[][] map, int[] point) {
        for(int i=point[0]*2; i<=point[2]*2; i++) {
            map[i][point[1]*2] = num;
            map[i][point[3]*2] = num;
        }
        for(int i=point[1]*2; i<=point[3]*2; i++) {
            map[point[0]*2][i] = num;
            map[point[2]*2][i] = num;
        }
        
        num++;
    }
    
    private void delete(int[][] map, int[] point) {
        for(int i=point[0]*2+1; i<point[2]*2; i++) {
            for(int j=point[1]*2+1; j<point[3]*2; j++) {
                map[i][j] = 0;
            }
        }
    }
}