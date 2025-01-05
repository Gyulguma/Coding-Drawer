import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N ;
	static Integer[][] arr;
	static Integer[][] dp;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());;
		
		arr = new Integer[N][N];
		dp = new Integer[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <= i ;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		
		for(int i = 0 ; i < N ; i++)
		max(N-1,i);
		
		int max_value = 0;
		for(int i = 0 ; i < N ;i++)
			max_value = Math.max(max_value, dp[N-1][i]);
		
		System.out.println(max_value);
}
	public static int max(int row, int col) {
		
		if(dp[row][col] == null) {
			if(col==0) {
				dp[row][col] = max(row-1,col) + arr[row][col];
			}
			else if(row==col) {
				dp[row][col] = max(row-1,col-1) + arr[row][col];
			}	
			else
				dp[row][col] = Math.max(max(row-1,col), max(row-1,col-1)) + arr[row][col];
		}
		
		return dp[row][col];
	}
}