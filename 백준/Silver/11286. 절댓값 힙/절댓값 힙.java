import java.io.*;
import java.util.*;


public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int repeat = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
			return Integer.compare(Math.abs(o1), Math.abs(o2));
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<repeat; i++) {
			int oper = Integer.parseInt(br.readLine());
			
			if(oper != 0) {
				pq.offer(oper);
				continue;
			}
			if(pq.isEmpty()) sb.append(0).append("\n");
			else sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
