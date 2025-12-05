import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int test=0; test<t; test++) {
        	int m = Integer.parseInt(br.readLine());
    		StringTokenizer st = null;
    		
    		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
    		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    		
    		List<Integer> list = new ArrayList<>();
    		for(int i=0; i<m; i++) {
    			if(i%10 == 0) st = new StringTokenizer(br.readLine());
    			
    			int num = Integer.parseInt(st.nextToken());
    			
    			if(maxHeap.size() == minHeap.size()) minHeap.offer(num);
    			else if(maxHeap.size() < minHeap.size()) maxHeap.offer(num);
    			
    			while(maxHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
    				int temp = maxHeap.poll();
    				maxHeap.offer(minHeap.poll());
    				minHeap.offer(temp);
    			}
    			
    			if(i%2 == 0) list.add(minHeap.peek());
    		}
    		
    		sb.append(list.size());
    		for(int i=0; i<list.size(); i++) {
    			if(i%10 == 0) sb.append("\n");
    			else sb.append(" ");
    			sb.append(list.get(i));
    		}
    		sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
   
}
