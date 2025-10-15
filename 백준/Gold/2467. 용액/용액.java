import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		
		int left = 0;
		int right = n-1;
		while(left < right) {
			int mix = numbers[left]+numbers[right];
			if(mix == 0) {
				System.out.println(numbers[left]+" "+numbers[right]);
				return;
			}
			
			if(min > Math.abs(mix)) {
				min = Math.abs(mix);
				answer[0] = numbers[left];
				answer[1] = numbers[right];
			}
			
			if(mix < 0) left++;
			else right--;
		}
		
		System.out.println(answer[0] + " "+ answer[1]);
	}

}