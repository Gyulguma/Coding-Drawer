import java.util.*;
import java.io.*;

public class Main{
	static class Edge{
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	private static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
		}
		
		int[] dist = new int[v+1];
		Arrays.fill(dist, INF);
//		boolean[] visited = new boolean[v+1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			
			int current = info[0];
			int cost = info[1];
			
			for(Edge edge : graph[current]) {
				if(dist[edge.to] <= cost + edge.weight) continue;
				dist[edge.to] = cost + edge.weight;
				pq.offer(new int[] {edge.to, dist[edge.to]});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=v; i++) {
			int result = dist[i];
			if(result == INF) sb.append("INF");
			else sb.append(result);
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}