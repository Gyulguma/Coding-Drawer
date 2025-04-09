import java.io.*;
import java.util.*;

public class Main {
	private static final String HAPPY = "happy";
	private static final String SAD = "sad";
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<repeat; r++) {
        	int n = Integer.parseInt(br.readLine())+2;
        	
        	int[] x = new int[n];
        	int[] y = new int[n];
        	for(int i=0; i<n; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		x[i] = Integer.parseInt(st.nextToken());
        		y[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int[][] dist = new int[n][n];
        	for(int i=0; i<n; i++) {
        		Arrays.fill(dist[i], (int) 1e9);
        	}
        	
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			if(i==j) dist[i][j] = 0;
        			else dist[i][j] = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
        		}
        	}
        	
        	boolean[] visited = new boolean[n];
        	Queue<Integer> q = new LinkedList<>();
        	q.offer(0);
        	visited[0] = true;
        	boolean isSuccess = false;
        	while(!q.isEmpty()) {
        		int current = q.poll();
        		
        		if(current == n-1) {
        			isSuccess = true;
        			break;
        		}
        		
        		for(int i=0; i<n; i++) {
        			if(visited[i] || dist[current][i] > 1000) continue;
        			q.offer(i);
        			visited[i] = true;
        		}
        	}
        	
        	if(isSuccess) sb.append(HAPPY).append("\n");
        	else sb.append(SAD).append("\n");
        	
        }
        
        System.out.println(sb.toString().trim());
    }
}
