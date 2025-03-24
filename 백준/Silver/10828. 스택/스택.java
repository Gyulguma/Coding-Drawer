import java.io.*;
import java.util.*;


public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int repeat = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<repeat; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			switch(oper) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
				break;
			}
		}
	}
}
