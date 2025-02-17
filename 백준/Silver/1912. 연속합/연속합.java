import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] numbers = new int[n+1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int j=1; j<=n; j++) {
    		numbers[j] = Integer.parseInt(st.nextToken());
    	}
    	int[] dp = new int[n+1];
    	int max = numbers[1];
    	dp[1] = numbers[1];
    	for(int i=2; i<=n; i++) {
    		dp[i] = Math.max(dp[i-1]+numbers[i], numbers[i]);
    		max = Math.max(max, dp[i]);
    	}
    	System.out.println(max);
    }
    
}
