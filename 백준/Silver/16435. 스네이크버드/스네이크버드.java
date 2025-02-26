import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] height = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(height);
		for(int i=0; i<n; i++) {
			if(height[i] > l) break;
			l++;
		}
		
		System.out.println(l);
		
	}
}
