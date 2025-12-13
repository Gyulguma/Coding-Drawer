import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Edge> edges = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(from, to, cost));
		}
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, (int)1e9);
		
		dist[1] = 0;
		for(int i=1; i<n; i++) {
			for(Edge edge : edges) {
				if(dist[edge.from] == (int)1e9) continue;
				if(dist[edge.to] > dist[edge.from] + edge.cost) {
					dist[edge.to] = dist[edge.from] + edge.cost;
				}
			}
		}
		
		// cycle
		for(Edge edge : edges) {
			if(dist[edge.from] == (int)1e9) continue;
			if(dist[edge.to] > dist[edge.from] + edge.cost) {
				System.out.println(-1);
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=n; i++) {
			if(dist[i] == (int)1e9) sb.append(-1);
			else sb.append(dist[i]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	private static class Edge{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
