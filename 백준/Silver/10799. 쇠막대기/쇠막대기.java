import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<input.length()-1; i++) {
        	char c = input.charAt(i);
        	if(c == ')') {
        		stack.pop();
        		count++;
        		continue;
        	}
        	if(input.charAt(i+1) == ')') {
        		count += stack.size();
        		i++;
        		continue;
        	}
        	stack.push(c);
        }
        if(!stack.isEmpty()) count++;
        
        System.out.println(count);
    }
}
