import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
	
public class Main{
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader inputStr = new BufferedReader(new InputStreamReader(System.in));

		int line = Integer.parseInt(inputStr.readLine());

		int[] time = new int[line+1];
		int[] pay = new int[line+1];
		int[] dp = new int[line+2];
		int max = 0;
		String[] tmp;
		
		for(int i = 1; i <= line; i++) {
			tmp = inputStr.readLine().split(" ");
			
			time[i] = Integer.parseInt(tmp[0]);
			pay[i] = Integer.parseInt(tmp[1]);
		}
		
		for(int j = 1; j <= line + 1; j++) {
			dp[j] = Math.max(max, dp[j]);
			
			if(j <= line && j+time[j] <= line + 1) {
				dp[j + time[j]] = Math.max(dp[j] + pay[j], dp[j + time[j]]);	
			}			
			
			max = Math.max(max, dp[j]);
		}
		
		System.out.println(max);
	}
}