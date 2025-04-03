import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long max = 0;
		long[] trees = new long[n];
		for(int i=0; i<n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		long result = 0;
		long left = 0;
		long right = max;
		while(left <= right) {
			// 절단기 높이
			long mid = left + (right-left)/2;
			
			long count = counting(trees, mid);
			
			if(count >= m) {
				left = mid+1;
				result = Math.max(result, mid);
			}
			else {
				right = mid-1;
			}
		}
		
		System.out.println(result);
	}

	private static long counting(long[] trees, long limit) {
		long count = 0;
		for(int i=0; i<trees.length; i++) {
			if(trees[i] <= limit) continue;
			count += trees[i] - limit;
		}
		
		return count;
	}
}
