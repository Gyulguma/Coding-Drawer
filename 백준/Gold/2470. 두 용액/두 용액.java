import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = n-1;
		
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		
		while(left < right) {
			long sum = (long)nums[left] + nums[right];
			
			if(Math.abs(sum) < min) {
				min = (int)Math.abs(sum);
				answer[0] = nums[left];
				answer[1] = nums[right];
			}
			
			if(min == 0) break;
			
			if(sum < 0) {
				left++;
				continue;
			}
			
			right--;
		}
		
		System.out.println(answer[0]+" "+answer[1]);
	}
}
