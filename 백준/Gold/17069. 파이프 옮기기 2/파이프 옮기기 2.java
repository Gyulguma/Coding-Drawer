import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] map = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][][] dp = new long[n+1][n+1][3];
        dp[1][2][0] = 1;
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(i==1 && j<3) continue;
        		if(map[i][j] == 1) continue;
        		dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
        		dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
        		if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
        		dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
        	}
        }
        
        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}
