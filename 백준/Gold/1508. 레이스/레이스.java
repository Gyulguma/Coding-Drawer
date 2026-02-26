import java.io.*;
import java.util.*;

public class Main {
	private static int n, m, k;
	private static int[] points;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		points = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}
		
		String answer = "";
		int left = 1;
		int right = n;
		while(left <= right) {
			int mid = left + (right-left)/2;
			
			String picture = test(mid);
			
			if(picture == "") {
				right = mid - 1;
				continue;
			}
			
			left = mid + 1;
			answer = picture;
		}
		
		System.out.println(answer);
	}
	
	private static String test(int min) {
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		int count = 1;
		int pre = points[0];
		for(int i=1; i<k; i++) {
			if(count == m) {
				sb.append(0);
				continue;
			}
			if(min > points[i] - pre) {
				sb.append(0);
				continue;
			}
			sb.append(1);
			count++;
			pre = points[i];
			
		}
		
		if(count == m) return sb.toString();
		return "";
	}
}
	