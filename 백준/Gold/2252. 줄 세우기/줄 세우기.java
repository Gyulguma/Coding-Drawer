import java.io.*;
import java.util.*;

public class Main {
	private static List<Integer>[] graph;
	private static int[] group;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] pre = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			pre[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(pre[i] == 0) q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int current = q.poll();
			
			sb.append(current).append(" ");
			
			for(int node : graph[current]) {
				pre[node]--;
				if(pre[node] == 0) q.offer(node);
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
