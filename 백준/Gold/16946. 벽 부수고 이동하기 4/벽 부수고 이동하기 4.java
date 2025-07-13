import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<m; j++) {
        		map[i][j] = line.charAt(j)-'0';
        	}
        }
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        Area[][] areas = new Area[n][m];
        int[][] d = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(map[i][j] == 1 || visited[i][j]) continue;
        		q.clear();
        		
        		Area area = new Area();
        		q.offer(new int[] {i,j});
        		visited[i][j] = true;
        		while(!q.isEmpty()) {
        			int[] info = q.poll();
        			int x = info[0];
        			int y = info[1];
        			
        			areas[x][y] = area;
        			area.upCount();
        			
        			for(int idx=0; idx<4; idx++) {
        				int nx = x + d[idx][0];
        				int ny = y + d[idx][1];
        				if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == 1 || visited[nx][ny]) continue;
        				
        				visited[nx][ny] = true;
        				q.offer(new int[] {nx, ny});
        			}
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(map[i][j] == 0) {
        			sb.append(0);
        			continue;
        		}
        		
        		Set<Area> set = new HashSet<>();
        		for(int idx=0; idx<4; idx++) {
        			int nx = i + d[idx][0];
        			int ny = j + d[idx][1];
        			if(nx<0 || nx>=n || ny<0 || ny>=m || areas[nx][ny] == null) continue;
        			
        			set.add(areas[nx][ny]);
        		}
        		
        		if(set.size() == 0) {
        			sb.append(1);
        			continue;
        		}
        		
        		int count = 1;
        		for(Area area : set) {
        			count += area.count;
        		}
        		sb.append(count%10);
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    private static class Area{
    	int count;
    	
    	public Area() {
    		this.count = 0;
    	}
    	
    	public void upCount() {
    		this.count++;
    	}
    }
}
