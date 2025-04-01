import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int[][] graph;
	private static int min = Integer.MAX_VALUE;
	private static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        graph = new int[n][n];
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
        	visited[i] = true;
        	dfs(1, 0, i, i);
        }
        System.out.println(min);
    }
    
    private static void dfs(int deth, int total, int current, int start) {
    	if(deth == n) {
    		if(graph[current][start] == 0) return;
    		total += graph[current][start];
    		min = Math.min(min, total);
    		return;
    	}
    	
    	if(total > min) return;
    	
    	for(int i=0; i<n; i++) {
    		if(visited[i] || graph[current][i] == 0) continue;
    		visited[i] = true;
    		dfs(deth+1, total+graph[current][i], i, start);
    		visited[i] = false;
    	}
    }
}
