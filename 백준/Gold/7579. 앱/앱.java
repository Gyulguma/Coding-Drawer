import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] memory = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	memory[i] = Integer.parseInt(st.nextToken());
        }
        int[] cost = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i=1; i<=n; i++) {
        	cost[i] = Integer.parseInt(st.nextToken());
        	total += cost[i];
        }
        
        long[] dp = new long[total+1];
        
        for(int i=1; i<=n; i++) {
        	for(int j=total; j>=cost[i]; j--) {
        		dp[j] = Math.max(dp[j], dp[j-cost[i]]+memory[i]);
        	}
        }
        
        for(int i=0; i<=total; i++) {
        	if(dp[i] < m) continue;
        	System.out.println(i);
        	return;
        }
    }
}
