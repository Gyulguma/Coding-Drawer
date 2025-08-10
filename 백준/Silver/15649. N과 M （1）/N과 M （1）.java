import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static int[] numbers, results;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[n];
		for(int i=1; i<=n; i++) {
			numbers[i-1] = i;
		}
		
		results = new int[m];
		visited = new boolean[n];
		dfs(0, 0);
		System.out.println(sb.toString());
	}
	
	private static void dfs(int current, int count) {
		if(count == m) {
			for(int number : results) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			results[current] = numbers[i];
			dfs(current+1, count+1);
			visited[i] = false;
		}
	}
}
