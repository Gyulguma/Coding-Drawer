import java.util.*;
import java.io.*;

public class Main{
	private static int[] parent;
	private static int n, m;
	private static int total, max;
	private static PriorityQueue<Edge> pq;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        pq = new PriorityQueue<>();
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            pq.offer(new Edge(from, to, value));
        }
        
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
        	parent[i] = i;
        }
        
        total = 0;
        max = 0;
        
        kruscal();
        
        System.out.println(total - max);
    }
    
    private static void kruscal() {
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(find(edge.from) == find(edge.to)) continue;
            
			union(edge.from, edge.to);
			total += edge.value;
			max = Math.max(max, edge.value);
		}
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) parent[y] = x;
	}

	private static int find(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}

	private static class Edge implements Comparable<Edge>{
    	int from;
    	int to;
    	int value;
    	
    	public Edge(int from, int to, int value) {
    		this.from = from;
    		this.to = to;
    		this.value = value;
    	}
    	
    	@Override
    	public int compareTo(Edge e) {
    		return Integer.compare(this.value, e.value);
    	}
    }
}