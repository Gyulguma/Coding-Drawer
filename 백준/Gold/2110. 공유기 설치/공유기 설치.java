import java.util.*;
import java.io.*;

public class Main{
	private static int n;
	private static int[] houses;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		houses = new int[n];
		for(int i=0; i<n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		
		int max = 0;
		
		int left = 1;
		int right = houses[n-1] - houses[0];
		while(left <= right) {
			int mid = left + (right-left)/2;
			int count = counting(mid);
			if(count < c) {
				right = mid-1;
				continue;
			}
			left = mid+1;
			max = Math.max(max, mid);
		}
		
		System.out.println(max);
	}
	
	private static int counting(int dist) {
		int count = 1;
		int pre = houses[0];
		for(int i=1; i<n; i++) {
			if(houses[i] - pre >= dist) {
				pre = houses[i];
				count++;
			}			
		}
		
		return count;
	}
}