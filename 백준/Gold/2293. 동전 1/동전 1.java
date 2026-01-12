import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n+1];
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(nums));
		
		int[][] dp = new int[n+1][k+1];
		for(int i=1; i<=k; i++) {
			if(i%nums[1] == 0) dp[1][i] = 1;
			else dp[1][i] = 0;
		}
		
		for(int i=2; i<=n; i++) {
			for(int l=1; l<=k; l++) {
				if(l%nums[i] == 0) dp[i][l] = 1;
				dp[i][l] += dp[i-1][l];
				for(int j=1; j<=l; j++) {
					if((l-nums[i]*j) <= 0) break;
					dp[i][l] += dp[i-1][l-nums[i]*j];
				}
			}
		}
		
//		for(int[] d : dp) System.out.println(Arrays.toString(d));
		System.out.println(dp[n][k]);
	}
}
