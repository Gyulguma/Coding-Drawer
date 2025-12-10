import java.io.*;
import java.util.*;

public class Main {
	private static List<Integer>[] graph;
	private static int[] group;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test=0; test<t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[v+1];
			for(int i=1; i<=v; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			group = new int[v+1];
			
			boolean flag = true;
			for(int i=1; i<=v; i++) {
				if(group[i] != 0) continue;
				if(!check(i)) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	private static boolean check(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		group[num] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int node : graph[current]) {
				if(group[current] == group[node]) return false;
				if(group[node] != 0) continue;
				
				group[node] = -group[current];
				q.offer(node);
			}
		}
		
		return true;
	}
}
