import java.util.*;

class Solution {
    private static int[][] d = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int solution(String dirs) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 2);
        map.put('L', 3);
        
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        for(char oper : dirs.toCharArray()) {
            int dir = map.get(oper);
            
            int nx = x + d[dir][0];
            int ny = y + d[dir][1];
            int ndir = 0;
            if(dir == 0) ndir = 1;
            else if(dir == 1) ndir = 0;
            else if(dir == 2) ndir = 3;
            else ndir = 2;
            
            if(nx<0 || nx>=11 || ny<0 || ny>=11) continue;
            if(!visited[nx][ny][dir]) answer++;
            visited[nx][ny][dir] = true;
            visited[x][y][ndir] = true;
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}