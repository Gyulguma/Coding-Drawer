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
		StringBuilder sb = new StringBuilder();
		
		int repeat = Integer.parseInt(br.readLine());
		for(int test=0; test<repeat; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			List<Edge>[] graph = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				int cost = c*2;
				
				if((a==x1 && b==x2) || (a==x2 && b==x1)) cost--;
				
				graph[a].add(new Edge(b, cost));
				graph[b].add(new Edge(a, cost));
			}
			
			int[] ends = new int[t];
			for(int i=0; i<t; i++) {
				ends[i] = Integer.parseInt(br.readLine());
			}
			
			int[] dist = new int[n+1];
			Arrays.fill(dist, (int) 1e9);
			boolean[] visited = new boolean[n+1];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
			pq.offer(new int[] {start, 0});
			dist[start] = 0;
			
			while(!pq.isEmpty()) {
				int[] info = pq.poll();
				int current = info[0];
				int currentCost = info[1];
				
				if(visited[current]) continue;
				visited[current] = true;
				
				for(Edge edge : graph[current]) {
					if(visited[edge.to]) continue;
					if(dist[edge.to] <= currentCost + edge.cost) continue;
					dist[edge.to] = currentCost + edge.cost;
					pq.offer(new int[] {edge.to, dist[edge.to]});
				}
			}
//			System.out.println(test+":"+Arrays.toString(dist));
			Arrays.sort(ends);
			for(int end : ends) {
				int cost = dist[end];
				if(cost%2 == 0) continue;
				sb.append(end).append(" ");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString().trim());
	}
}