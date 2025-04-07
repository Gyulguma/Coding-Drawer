import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int repeat = Integer.parseInt(br.readLine());
        for(int r=0; r<repeat; r++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] coin = new int[n+1];
        	for(int i=1; i<=n; i++) {
        		coin[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int m = Integer.parseInt(br.readLine());
        	
        	int[][] dp = new int[n+1][m+1];
        	for(int i=1; i<=m; i++) {
        		if(i%coin[1] != 0) continue;
        		dp[1][i]++;
        	}
        	
        	for(int i=2; i<=n; i++) {
        		for(int j=1; j<=m; j++) {
        			dp[i][j] = (j%coin[i] == 0) ? 1 : 0;
        			for(int k=0; k<=j/coin[i]; k++) {
        				dp[i][j] += dp[i-1][j-(coin[i]*k)];
        			}
        		}
        	}
        	
        	sb.append(dp[n][m]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}
