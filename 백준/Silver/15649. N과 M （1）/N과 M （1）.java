import java.util.*;
import java.io.*;

public class Main{
	private static int n, m;
	private static int[] numbers, results;
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[n];
		for(int i=1; i<=n; i++) {
			numbers[i-1] = i;
		}
		
		results = new int[m];
		visited = new boolean[n+1];
		recur(0, 0);
		
		System.out.println(sb.toString().trim());
	}
	
	private static void recur(int curIdx, int count) {
		if(count == m) {
			for(int number : results) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			results[curIdx] = i;
			recur(curIdx+1, count+1);
			visited[i] = false;
		}
	}
}