import java.util.*;

class Solution {
    private int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    private char[][] map;
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        int[] start = {};
        int[] laber = {};
        int[] end = {};
        
        int i=0; int j=0;
        for(String s : maps) {
            j=0;
            for(char c : s.toCharArray()) {
                if(c == 'S') start = new int[]{i, j};
                else if(c == 'L') laber = new int[]{i, j};
                else if(c == 'E') end = new int[]{i, j};
                
                map[i][j] = c;
                j++;
            }
            i++;
        }
        
        answer += bfs(start, laber);
        if(answer == 0) return -1;
        
        int temp = answer;
        answer += bfs(laber, end);
        if(answer == temp) return -1;
        
        return answer;
    }
    
    private int bfs(int[] start, int[] target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0];
            int y = info[1];
            int count = info[2];
            
            if(x == target[0] && y == target[1]) return count;
            
            for(int i=0; i<d.length; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length || map[nx][ny] == 'X' || visited[nx][ny]) continue;
                
                q.offer(new int[]{nx, ny, count+1});
                visited[nx][ny] = true;
            }
        }
        
        return 0;
    }
}