import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] tree = new int[(int)Math.pow(2, n+1)];
		
		st = new StringTokenizer(br.readLine());
		tree[1] = 0;
		for(int i=2; i<tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		//find max
		long max = 0;
		int limit = (int)Math.pow(2, n+1);
		for(int i=(int)Math.pow(2, n); i<limit; i++) {
			long count = 0;
			int parent = i;
			while(parent > 0) {
				count += tree[parent];
				parent /= 2;
			}
			max = Math.max(max, count);
		}
		
		//setting
		boolean[] visited = new boolean[tree.length];
		visited[1] = true;
		
		for(int i=1; i<=n; i++) {
			int base = (int) Math.pow(2, i+1);
			int end = (int)Math.pow(2, n+1);
			for(int j=(int)Math.pow(2, n); j<end; j++) {
				long count = 0;
				int current = j;
				while(current >= base) {
					count += tree[current];
					current /= 2;
				}
				int parent = current/2;
				int parentCount = 0;
				while(parent > 0) {
					parentCount += tree[parent];
					parent /= 2;
				}
				if(!visited[current]) {
					tree[current] = (int) (max-parentCount);
					visited[current] = true;
				}
				tree[current] = (int) Math.min(tree[current], max-(count+parentCount));
			}
			
			
		}
		
		//total sum
		int sum = 0;
		for(int i=2; i<tree.length; i++) {
			sum += tree[i];
		}
		
		System.out.println(sum);
	}
}
