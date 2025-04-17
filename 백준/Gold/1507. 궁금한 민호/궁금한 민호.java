import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		map[i][j] = graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        int result = 0;
        int[] dist = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(dist[o1], dist[o2]));
        for(int i=0; i<n; i++) {
        	for(int j=i+1; j<n; j++) {
        		pq.clear();
        		Arrays.fill(dist, (int) 1e9);
        		dist[i] = 0;
        		boolean[] visited = new boolean[n];
        		pq.offer(i);
        		
        		while(!pq.isEmpty()) {
        			int current = pq.poll();
        			
        			if(visited[current]) continue;
        			visited[current] = true;
        			
        			if(current == j) break;
        			
        			for(int node=0; node<n; node++) {
        				if(visited[node]) continue;
        				if(current==i && node==j) continue;
        				if(current==j && node==i) continue;
        				
        				if(dist[node] <= dist[current] + graph[current][node]) continue;
        				dist[node] = dist[current] + graph[current][node];
        				
        				pq.offer(node);
        			}
        		}
        		
        		if(dist[j] > map[i][j]) {
        			result += map[i][j];
//        			System.out.println((i+1)+"->"+(j+1));
        			continue;
        		}
        		if(dist[j] < map[i][j]) {
        			System.out.println(-1);
        			return;
        		}
        		graph[i][j] = (int) 1e9;
        		graph[j][i] = (int) 1e9;
        	}
        }
        
        System.out.println(result);
    }
}
