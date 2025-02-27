import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[][] d = {{-1,1},{0,1},{1,1}};
	private static int count=0;
	private static boolean[][] visited;
	private static int r,c;
	private static char[][] map;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map  = new char[r][c];
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		
		visited = new boolean[r][c];
		count = 0;
		for(int i=0; i<r; i++) {
			visited[i][0] = true;
			if(backtracking(i,0)) count++;
		}
		System.out.println(count);
	}
	
	private static boolean backtracking(int x, int y) {
		if(y == c-1) {
			return true;
		}
		for(int i=0; i<d.length; i++) {
			int nx = x+d[i][0];
			int ny = y+d[i][1];
			if(nx<0 || nx>=r || visited[nx][ny] || map[nx][ny] == 'x') continue;
			
			visited[nx][ny] = true;
			if(backtracking(nx, ny)) return true;
		}
		return false;
	}
}
