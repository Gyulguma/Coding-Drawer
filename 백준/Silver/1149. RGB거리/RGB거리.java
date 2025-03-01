import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
    	int n = Integer.parseInt(br.readLine());
    	int[][] cost = new int[n+1][3];
    	
    	for(int i=1; i<=n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j=0; j<3; j++) {
    			cost[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] dp = new int[n+1][3];
    	
    	for(int i=1; i<=n; i++) {
    		dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
    		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
    		dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
    	}
    	
    	int min = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    	System.out.println(min);
    }
    
}
