import java.io.*;
import java.util.*;

public class Main {
	private static int min = Integer.MAX_VALUE;
	private static int n,m;
	private static int[][] map;
	private static List<int[]> virus;
	private static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		virus = new ArrayList<>();
		int room = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new int[] {i, j});
				if(map[i][j] != 1) room++;
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(room - 3 - min);
	}
	
	private static void dfs(int x, int y, int count) {
		if(count == 3) {
			min = Math.min(min, bfs());
			return;
		}
		
		for(int i=x; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i==x && j<y) continue;
				if(map[i][j] != 0) continue;
				map[i][j] = 1;
				dfs(i, j, count+1);
				map[i][j] = 0;
			}
		}
	}
	
	private static int bfs() {
		int count = 0;
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		for(int[] v : virus) {
			q.offer(new int[] {v[0], v[1]});
			visited[v[0]][v[1]] = true;
			count++;
		}
		
		while(!q.isEmpty()) {
			if(count > min) return Integer.MAX_VALUE;
			
			int[] info = q.poll();
			int x = info[0];
			int y = info[1];
		
			for(int i=0; i<d.length; i++) {
				int nx = x + d[i][0];
				int ny = y + d[i][1];
				if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] != 0 || visited[nx][ny]) continue;
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				count++;
			}
		}
		
		return count;
	}
}
