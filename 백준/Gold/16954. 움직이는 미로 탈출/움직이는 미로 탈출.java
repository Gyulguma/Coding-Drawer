import java.io.*;
import java.util.*;

public class Main {
	private static int n = 8;
	private static int[][] d = {{0,0},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int wallCount = 0;
        int[] wall = new int[8];

        char[][] map = new char[n][n];
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<n; j++) {
        		map[i][j] = line.charAt(j);
        		if(map[i][j] != '#') continue;
        		wallCount++;
        		wall[i]++;        		
        	}
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {7,0});
        while(true) {
        	if(q.isEmpty()) {
        		System.out.println("0");
        		return;
        	}
        	
//        	if(wallCount == 0) {
//        		System.out.println("1");
//        		return;
//        	}
        	
        	int size = q.size();
        	boolean[][] visited = new boolean[n][n];
        	for(int i=0; i<size; i++) {
        		int[] info = q.poll();
        		int x = info[0];
        		int y = info[1];
        		
        		if(x == 0 && y == 7) {
        			System.out.println("1");
        			return;
        		}
        		
        		for(int idx=0; idx<d.length; idx++) {
        			int nx = x + d[idx][0];
        			int ny = y + d[idx][1];
        			if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]) continue;
        			if(map[nx][ny] == '#' || (nx-1>=0 && map[nx-1][ny] == '#')) continue;
        			q.offer(new int[] {nx, ny});
        			visited[nx][ny] = true;
        		}
        	}
        	
        	for(int j=0; j<n; j++) {
        		if(map[n-1][j] != '#') continue;
        		map[n-1][j] = '.';
        		wallCount--;
        		wall[n-1]--;
        	}
        	
        	for(int i=n-2; i>=0; i--) {
        		for(int j=0; j<n; j++) {
        			if(map[i][j] != '#') continue;
        			map[i][j] = '.';
        			map[i+1][j] = '#';
        			wall[i]--;
        			wall[i+1]++;
        		}
        	}
        }
    }
}
