import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!str.equals(".")){
            stack.clear();
            str = str.replaceAll("[a-zA-Z]", "").trim();
            for(char c : str.toCharArray()){
                if(c == '.') break;
                if(c == '(' || c == '['){
                    stack.push(c);
                    continue;
                }
                if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
            str = br.readLine();
        }
        System.out.println(sb.toString().trim());
    }
}