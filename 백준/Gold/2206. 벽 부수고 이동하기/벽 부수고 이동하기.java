import java.io.*;
import java.util.*;

public class Main {
	private static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			for(int j=1; j<=m; j++) {
				map[i][j] = input.charAt(j-1) - '0';
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		boolean[][][] visited = new boolean[n+1][m+1][2];
		
		pq.offer(new int[] {1, 1, 1, 0});
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int x = info[0];
			int y = info[1];
			int count = info[2];
			int broken = info[3];
			
			if(visited[x][y][broken]) continue;
			
			if(x==n && y==m) {
				System.out.println(count);
				return;
			}
			
			visited[x][y][broken] = true;
			
			for(int i=0; i<d.length; i++) {
				int nx = x + d[i][0];
				int ny = y + d[i][1];
				
				if(nx<=0 || nx>n || ny<=0 || ny>m || visited[nx][ny][broken]) continue;
				if(map[nx][ny] == 1) {
					if(broken == 1) continue;
					pq.offer(new int[] {nx, ny, count+1, broken+1});
					continue;
				}
				pq.offer(new int[] {nx, ny, count+1, broken});
				
			}
		}
		
		System.out.println(-1);
	}
}
