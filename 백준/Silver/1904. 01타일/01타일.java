import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        if(n==1) {
        	System.out.println(1);
        	return;
        }
        dp[2] = 2;
        if(n==2) {
        	System.out.println(2);
        	return;
        }
        for(int i=3; i<=n; i++) {
        	dp[i] = (dp[i-1] + dp[i-2])%15746;
        }
        
        System.out.println(dp[n]);
    }
    
}
