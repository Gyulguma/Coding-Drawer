import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(nums);
		int left = 0;
		int right = n-1;
		
		int result = 0;
		while(left < right) {
			int sum = nums[left] + nums[right];
			
			
			if(sum > x) {
				right--;
				continue;
			}
			if(sum == x) result++;
			left++;
			right = n-1;
		}
		
		System.out.println(result);
	}
}
