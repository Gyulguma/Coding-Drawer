import java.io.*;
import java.util.*;

public class Main {
	private static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				if(graph[i][j] == INF || graph[j][i] == INF) continue;
				min = Math.min(min, graph[i][j] + graph[j][i]);
			}
		}
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	private static class Edge {
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
