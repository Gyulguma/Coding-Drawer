import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] problems = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			problems[i][0] = Integer.parseInt(st.nextToken());
			problems[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(problems, (o1, o2) ->{
			if(o1[0] != o2[0]) return o1[0] - o2[0];
			return o2[1] - o1[1];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			int[] target = problems[i];
			if(pq.size() < target[0]) {
				pq.offer(target[1]);
				continue;
			}
			
			if(pq.peek() < target[1]) {
				pq.poll();
				pq.offer(target[1]);
			}
		}
		
		int result = 0;
		while(!pq.isEmpty()) result += pq.poll();
		
		System.out.println(result);
	}
}
