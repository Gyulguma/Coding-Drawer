import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		pq.offer(Integer.parseInt(st.nextToken()));
        	}
        }
        
        int result = 0;
        for(int i=0; i<n; i++) {
        	result = pq.poll();
        }
        System.out.println(result);
        
        
    }
    
   
}
