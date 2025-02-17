import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	
    	int repeat = Integer.parseInt(br.readLine());
    	for(int j=0; j<repeat; j++) {
    		int n = Integer.parseInt(br.readLine());
            
            long[] dp = new long[101];
            
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;
            for(int i=6; i<=n; i++) {
            	dp[i] = dp[i-1] + dp[i-5];
            }
            
            sb.append(dp[n]).append("\n");
    	}
        System.out.println(sb);
    }
    
}
