import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N ;
	static int[][] ele;
	static Integer[] dp;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());;
		
		ele = new int[N][2];
		dp = new Integer[N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ele[i][0]=Integer.parseInt(st.nextToken());
			ele[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ele, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for(int i = 0 ; i < N ; i ++) {
			max = Math.max(electronic(i), max);
		}

		System.out.println(N-max);
}
	public static int electronic(int num) {
		
		if(dp[num]==null) {
			dp[num]=1;
			
			for(int i = num+1 ; i < dp.length ; i ++) {
				if(ele[num][1] < ele[i][1])
					dp[num]=Math.max(dp[num], electronic(i)+1);
			}
		}
		
		return dp[num];
	}

}