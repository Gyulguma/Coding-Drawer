import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<int[]>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
		}
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, (int) 1e9);
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(dist[o1], dist[o2]));
		boolean[] visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		pq.add(start);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			if(visited[current]) continue;
			visited[current] = true;
			if(current == end) {
				System.out.println(dist[current]);
				return;
			}
			
			for(int[] info : graph[current]) {
				if(visited[info[0]]) continue;
				if(dist[info[0]] < dist[current] + info[1]) continue;
				dist[info[0]] = dist[current] + info[1];
				pq.offer(info[0]);
			}
		}
	}
}