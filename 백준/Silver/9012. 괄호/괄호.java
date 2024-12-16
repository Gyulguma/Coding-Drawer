import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++){
            stack.clear();
            String s = br.readLine();
            for(char ch : s.toCharArray()){
                if(ch == '('){
                    stack.push(ch);
                    continue;
                }
                if(stack.isEmpty()){
                    stack.push(ch);
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append("YES\n");
            }
            else sb.append("NO\n");
        }
        System.out.println(sb.toString().trim());
    }
}