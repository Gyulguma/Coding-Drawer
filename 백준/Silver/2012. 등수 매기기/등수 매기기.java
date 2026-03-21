import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		long answer = 0;
		for(int i=1; i<=n; i++) {
			answer += Math.abs((long)i-nums[i-1]);
		}
		
		System.out.println(answer);
	}
}
	