import java.util.*;
import java.io.*;

public class Main{
	static class Edge {
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
		}
		
		int[] xToHomeDist = new int[n+1];
		Arrays.fill(xToHomeDist, (int) 1e9);
//		xToHomeDist[x] = 0;
		boolean[] visited = new boolean[n+1];
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(xToHomeDist[o1], xToHomeDist[o2]));
		
		pq.offer(x);
		xToHomeDist[x] = 0;
		while(!pq.isEmpty()) {
			int current = pq.poll();
			if(visited[current]) continue;
			visited[current] = true;
			
			for(Edge edge : graph[current]) {
				if(visited[edge.to]) continue;
				if(xToHomeDist[edge.to] < xToHomeDist[current] + edge.cost) continue;
				xToHomeDist[edge.to] = xToHomeDist[current] + edge.cost;
				pq.offer(edge.to);
			}
		}
		
//		System.out.println(Arrays.toString(xToHomeDist));
		
		int max = 0;
		for(int start=1; start<=n; start++) {
			int[] dist = new int[n+1];
			pq = new PriorityQueue<>((o1, o2) -> Integer.compare(dist[o1], dist[o2]));
//			dist[x] = 0;
			Arrays.fill(dist, (int) 1e9);
			visited = new boolean[n+1];
			pq.offer(start);
			dist[start] = 0;
			
			int cost = 0;
			while(!pq.isEmpty()) {
				int current = pq.poll();
				
				if(current == x) {
					cost = dist[current];
					break;
				}
				
				if(visited[current]) continue;
				visited[current] = true;
				
				for(Edge edge : graph[current]) {
					if(visited[edge.to]) continue;
					if(dist[edge.to] < dist[current] + edge.cost) continue;
					dist[edge.to] = dist[current] + edge.cost;
					pq.offer(edge.to);
				}
			}
//			System.out.println(start+":"+Arrays.toString(dist)+"->"+(cost+xToHomeDist[start]));
			max = Math.max(max, cost+xToHomeDist[start]);
		}
		
		System.out.println(max);
	}
}