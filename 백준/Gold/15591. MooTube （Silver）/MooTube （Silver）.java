import java.io.*;
import java.util.*;

public class Main {
	private static class Edge{
		private int to;
		private int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[][] usados = new int[n+1][n+1];
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to, weight));
			graph[to].add(new Edge(from, weight));
		}
		
		
		for(int i=1; i<=n; i++) {
			boolean[] visited = new boolean[n+1];
			Queue<int[]> queue = new LinkedList<>();
			for(Edge edge : graph[i]) {
				queue.offer(new int[] {edge.to, edge.weight});
			}
			visited[i] = true;
			
			while(!queue.isEmpty()) {
				int[] info = queue.poll();
				int current = info[0];
				int minWeight = info[1];
				
				visited[current] = true;
				usados[i][current] = minWeight;
				for(Edge edge : graph[current]) {
					if(visited[edge.to]) continue;
					queue.offer(new int[] {edge.to, Math.min(edge.weight, minWeight)});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for(int j=1; j<=n; j++) {
				if(usados[start][j] >= k) count++;
			}
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
	