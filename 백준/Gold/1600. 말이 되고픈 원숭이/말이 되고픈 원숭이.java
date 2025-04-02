import java.io.*;
import java.util.*;

public class Main {
	private static int[][] hd = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[h][w];
        for(int i=0; i<h; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<w; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        boolean[][][] visited = new boolean[h][w][k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        pq.offer(new int[] {0,0,0,0});
        
        while(!pq.isEmpty()) {
        	int[] info = pq.poll();
        	int x = info[0];
        	int y = info[1];
        	int count = info[2];
        	int useH = info[3];
        	
        	if(x==h-1 && y==w-1) {
        		System.out.println(count);
        		return;
        	}
        	
        	if(visited[x][y][useH]) continue;
        	visited[x][y][useH] = true;
        	
        	if(useH < k) {
        		for(int i=0; i<hd.length; i++) {
        			int nx = x+hd[i][0];
        			int ny = y+hd[i][1];
        			if(nx<0 || nx>=h || ny<0 || ny>=w || visited[nx][ny][useH+1] || map[nx][ny] == 1) continue;
        			
        			pq.offer(new int[] {nx, ny, count+1, useH+1});
        		}
        	}
    		for(int i=0; i<d.length; i++) {
    			int nx = x+d[i][0];
    			int ny = y+d[i][1];
    			if(nx<0 || nx>=h || ny<0 || ny>=w || visited[nx][ny][useH] || map[nx][ny] == 1) continue;
    			
    			pq.offer(new int[] {nx, ny, count+1, useH});
    		}
        }
        
        System.out.println(-1);
    }
}
