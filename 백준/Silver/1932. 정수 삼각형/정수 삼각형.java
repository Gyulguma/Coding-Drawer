import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
    	int n = Integer.parseInt(br.readLine());
    	int[][] numbers = new int[n][];
    	
    	for(int i=1; i<=n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		numbers[i-1] = new int[i];
    		for(int j=0; j<i; j++) {
    			numbers[i-1][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] dp = new int[n][n];
    	dp[0][0] = numbers[0][0];
    	for(int i=0; i<n-1; i++) {
    		for(int j=0; j<numbers[i].length; j++) {
    			dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+numbers[i+1][j]);
    			dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+numbers[i+1][j+1]);
    		}
    	}
    	
    	
    	int max = 0;
    	for(int i=0; i<numbers[n-1].length; i++) {
    		max = Math.max(max, dp[n-1][i]);
    	}
    	System.out.println(max);
    }
    
}
