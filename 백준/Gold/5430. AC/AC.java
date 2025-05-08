import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int R = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        To: for(int repeat=0; repeat<R; repeat++) {
        	String operators = br.readLine();
        	
        	int n = Integer.parseInt(br.readLine());
        	Deque<Integer> dq = new LinkedList<>();
        	
        	boolean head = true;
        	
        	String input = br.readLine();
        	String[] arr = input.substring(1, (input.length()-1)).split(",");
        	
        	for(int i=0; i<n; i++) {
        		dq.add(Integer.parseInt(arr[i]));
        	}
        	
        	for(int i=0; i<operators.length(); i++) {
        		char c = operators.charAt(i);
        		if(c == 'R') {
        			head = !head;
        			continue;
        		}
        		
        		if(dq.isEmpty()) {
        			sb.append("error\n");
        			continue To;
        		}
        		
        		if(head) dq.pollFirst();
        		else dq.pollLast();
        	}

        	sb.append("[");
        	if(head) while(dq.size() > 1) sb.append(dq.pollFirst()).append(",");
        	else while(dq.size() > 1) sb.append(dq.pollLast()).append(",");
        	
        	if(dq.isEmpty()) sb.append("]\n");
        	else sb.append(dq.poll()).append("]\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}
