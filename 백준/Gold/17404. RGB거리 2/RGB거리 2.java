import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] cost = new int[n+1][3];
        for(int i=1; i<=n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	cost[i][0] = Integer.parseInt(st.nextToken());
        	cost[i][1] = Integer.parseInt(st.nextToken());
        	cost[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][3];
        
        for(int fix=0; fix<3; fix++) {
        	for(int i=0; i<3; i++) {
        		if(i==fix) dp[1][i] = cost[1][i];
        		else dp[1][i] = (int) 2e9;
        	}
        	for(int i=2; i<=n; i++) {
        		dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
        		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
        		dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        	}
        	for(int i=0; i<3; i++) {
        		if(i != fix) min = Math.min(min, dp[n][i]);
        	}
        }
        
        System.out.println(min);
    }
}
