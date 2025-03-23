import java.io.*;
import java.util.*;


public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static boolean[] visited;
	private static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		
		visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current+" ");
			for(int i=1; i<=n; i++) {
				if(visited[i] || graph[current][i] == 0) continue;
				visited[i] = true;
				q.offer(i);
			}
		}
		
		
		System.out.println(sb.toString().trim());
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		sb.append(current+" ");
		for(int i=1; i<=n; i++) {
			if(visited[i] || graph[current][i] == 0) continue;
			dfs(i);
		}
	}
}
