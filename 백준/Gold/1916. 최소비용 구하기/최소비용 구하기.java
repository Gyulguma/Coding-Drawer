import java.util.*;
import java.io.*;

public class Main{
	static class Edge{
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int hashCode() {
			return Integer.hashCode(this.to);
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Edge) {
				Edge e = (Edge) o;
				if(this.to == e.to) return true;
			}
			return false;
		}
	}
	private static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		Map<Integer, Integer> minWeight = new HashMap<>();
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			Edge edge = new Edge(b, c);
			graph[a].add(edge);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, (int) 1e9);
		boolean[] visited = new boolean[n+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int current = info[0];
			int cost = info[1];
			
			if(current == end) {
				System.out.println(dist[current]);
				return;
			}
			
			if(visited[current]) continue;
			visited[current] = true;
			
			for(Edge edge : graph[current]) {
				if(visited[edge.to]) continue;
				if(dist[edge.to] <= cost + edge.weight) continue;
				dist[edge.to] = cost + edge.weight;
				pq.offer(new int[] {edge.to, dist[edge.to]});
			}
		}
			
			
	}
}