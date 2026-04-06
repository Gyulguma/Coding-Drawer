import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println("SK");
			return;
		}
		if(n==2) {
			System.out.println("CY");
			return;
		}
		if(n==3) {
			System.out.println("SK");
			return;
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		
		for(int i=4; i<=n; i++) {
			dp[i] = (dp[i-1]==1 && dp[i-3]==1) ? 2 : 1;
		}
		
		System.out.println(dp[n]==1 ? "SK" : "CY");
	}
}
	