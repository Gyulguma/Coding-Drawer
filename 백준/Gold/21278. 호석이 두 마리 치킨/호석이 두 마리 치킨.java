import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) {
        	Arrays.fill(dist[i], (int) 1e9);
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(i==j) dist[i][j] = 0;
        	}
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	
        	dist[a][b] = 1;
        	dist[b][a] = 1;
        }
        
        for(int k=0; k<n; k++) {
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        		}
        	}
        }
        
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		int sum = 0;
        		for(int h=0; h<n; h++) {
        			sum += Math.min(dist[h][i], dist[h][j]) * 2;
        		}
        		if(sum < min) {
        			min = sum;
        			a = i+1;
        			b = j+1;
        		}
        	}
        }
        
        System.out.println(a + " " + b + " " + min);
    }
}
