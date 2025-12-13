import java.io.*;
import java.util.*;
/**
 * 
1
5
5 4 3 2 1
3
2 4
3 4
1 5
 *
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test=0; test<t; test++) {
			// init
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			Set<Integer>[] graph = new HashSet[n+1];
			for(int i=1; i<=n; i++) {
				graph[i] = new HashSet<>();
			}
			int[] pre = new int[n+1];
			
			int[] nums = new int[n];
			for(int i=n-1; i>=0; i--) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					graph[nums[i]].add(nums[j]);
					pre[nums[j]]++;
				}
			}
			
			// process
			int m = Integer.parseInt(br.readLine());
			boolean flag = false;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(graph[a].contains(b)) {
					graph[a].remove(b);
					pre[b]--;
					
					graph[b].add(a);
					pre[a]++;
					continue;
				}
				if(graph[b].contains(a)) {
					graph[b].remove(a);
					pre[a]--;
					
					graph[a].add(b);
					pre[b]++;
					continue;
				}
				
				flag = true;
			}
			
			// check 1
			if(flag) {
				sb.append("IMPOSSIBLE").append("\n");
				continue;
			}
			
			// make result
			Queue<Integer> q = new LinkedList<>();
			for(int i=1; i<=n; i++) {
				if(pre[i] == 0) q.offer(i);
			}
			
			int index = 0;
			while(!q.isEmpty()) {
				if(q.size() > 1) {
					flag = true;
					break;
				}
				int current = q.poll();
				
				nums[index] = current;
				
				for(int node : graph[current]) {
					pre[node]--;
					if(pre[node] == 0) q.offer(node);
				}
				index++;
			}

			// check 2
			if(flag || index < n) {
				sb.append("IMPOSSIBLE").append("\n");
				continue;
			}
			
			// result
			sb.append(nums[n-1]);
			for(int i=n-2; i>=0; i--) {
				sb.append(" ").append(nums[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
