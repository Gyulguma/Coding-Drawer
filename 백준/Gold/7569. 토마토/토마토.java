import java.io.*;
import java.util.*;

public class Main {
	private static int[][] d = {{1,0,0},{-1,0,0},{0,0,-1},{0,0,1},{0,1,0},{0,-1,0}};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int m = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	
        int[][][] store = new int[h][n][m];
        
        int unripe = 0;
        Queue<int[]> ripes = new LinkedList<>();
        
        for(int k=0; k<h; k++) {
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<m; j++) {
        			store[k][i][j] = Integer.parseInt(st.nextToken());
        			
        			if(store[k][i][j] == 0) unripe++;
        			if(store[k][i][j] == 1) ripes.offer(new int[] {k, i, j});
        		}
        	}
        }

        if(unripe == 0) {
        	System.out.println(0);
        	return;
        }
        
        int day = 0;
        while(!ripes.isEmpty()) {
        	
        	if(unripe == 0) {
        		System.out.println(day);
        		return;
        	}
        	
        	int count = ripes.size();
        	for(int i=0; i<count; i++) {
        		int[] info = ripes.poll();
        		int z = info[0];
        		int x = info[1];
        		int y = info[2];
        		
        		for(int index=0; index<d.length; index++) {
        			int nz = z + d[index][0];
        			int nx = x + d[index][1];
        			int ny = y + d[index][2];
        			if(nz<0 || nz>=h || nx<0 || nx>=n || ny<0 || ny>=m || store[nz][nx][ny] == -1 || store[nz][nx][ny] == 1) continue;
        			store[nz][nx][ny] = 1;
        			ripes.offer(new int[] {nz, nx, ny});
        			unripe--;
        		}
        		
        	}
        	day++;
        }
        
        System.out.println(-1);
    	return;
    }
}
