import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int R = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        To: for(int repeat=0; repeat<R; repeat++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	int[] building = new int[n+1];
        	st = new StringTokenizer(br.readLine());
        	for(int i=1; i<=n; i++) {
        		building[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	List<Integer>[] graph = new ArrayList[n+1];
        	for(int i=1; i<=n; i++) {
        		graph[i] = new ArrayList<>();
        	}
        	
        	int[] edgeCount = new int[n+1];
        	for(int i=0; i<k; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		graph[a].add(b);
        		edgeCount[b]++;
        	}
        	
        	int w = Integer.parseInt(br.readLine());
        	int[] cost = new int[n+1];
        	
        	Queue<Integer> q = new LinkedList<>();
        	for(int i=1; i<=n; i++) {
        		if(edgeCount[i] != 0) continue;
        		q.offer(i);
        	}
        	
        	while(!q.isEmpty()) {
        		int current = q.poll();
        		
        		cost[current] += building[current];
        		
        		if(current == w) {
        			sb.append(cost[w]).append("\n");
        			continue To;
        		}
        		
        		for(int node : graph[current]) {
        			edgeCount[node]--;
        			cost[node] = Math.max(cost[node], cost[current]);
        			if(edgeCount[node] == 0) {
        				q.offer(node);
        			}
        		}
        	}
        }
        
        System.out.println(sb.toString().trim());
    }
}
