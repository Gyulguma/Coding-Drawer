import java.io.*;
import java.util.*;

public class Main {
	private static int[][] d = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
	private static int l;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int test=0; test<t; test++) {
        	l = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        	st = new StringTokenizer(br.readLine());
        	int[] end = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        	
        	int result = bfs(start, end);
        	
        	sb.append(result).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

	private static int bfs(int[] start, int[] end) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[l][l];
		
		queue.offer(new int[] {start[0], start[1], 0});
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int x = info[0];
			int y = info[1];
			int count = info[2];
			
			if(x == end[0] && y == end[1]) return count;
			
			for(int i=0; i<d.length; i++) {
				int nx = x + d[i][0];
				int ny = y + d[i][1];
				if(nx<0 || nx>=l || ny<0 || ny>=l || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny, count+1});
			}
		}
		
		return -1;
	}
}
