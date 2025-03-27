import java.io.*;
import java.util.*;

public class Main {
	private static int[] parent;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        for(int i=0; i<=n; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	Edge edge = new Edge(a, b, c);
        	pq.offer(edge);
        }
        
        long result = 0;
        int edgecount = 0;
        while(!pq.isEmpty() && edgecount < n-1) {
        	Edge edge = pq.poll();
        	
        	if(union(edge.a, edge.b)) {
        		result += edge.value;
        		edgecount++;
        	}
        }
        
        System.out.println(result);
    }
    
    private static boolean union(int a, int b) {
		a = findRoot(a);
		b = findRoot(b);
		
		if(a == b) return false;
		parent[b] = a;
		return true;
	}

	private static int findRoot(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findRoot(parent[x]);
	}

	private static class Edge implements Comparable{
    	private int a;
    	private int b;
    	private int value;
    	
    	public Edge(int a, int b, int value) {
    		this.a = a;
    		this.b = b;
    		this.value = value;
    	}
    	
    	@Override
    	public int compareTo(Object o) {
    		Edge e = (Edge) o;
    		return Integer.compare(this.value, e.value);
    	}
    }
}
