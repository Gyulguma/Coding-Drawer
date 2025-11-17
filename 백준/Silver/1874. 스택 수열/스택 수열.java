import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int top = 1;
        stack.push(top++);
        sb.append("+").append("\n");
        for(int i=0; i<n; i++) {
        	int number = Integer.parseInt(br.readLine());
        	
        	while(stack.empty() || number > stack.peek()) {
        		stack.push(top++);
        		sb.append("+").append("\n");
        	}
        	
        	if(number != stack.peek()) {
        		System.out.println("NO");
        		return;
        	}
        	
        	stack.pop();
        	sb.append("-").append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
}
