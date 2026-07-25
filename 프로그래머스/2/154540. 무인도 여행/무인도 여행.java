import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        boolean[][] visited = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == 'X' || visited[i][j]) continue;
                int count = bfs(map, visited, i, j);
                list.add(count);
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(char[][] map, boolean[][] visited, int i, int j) {
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        
        int count = 0;
        while(!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0];
            int y = info[1];
            
            count += map[x][y]-'0';
            
            for(int idx=0; idx<d.length; idx++) {
                int nx = x+d[idx][0];
                int ny = y+d[idx][1];
                if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length) continue;
                if(map[nx][ny] == 'X' || visited[nx][ny]) continue;
                
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        return count;
    }
}