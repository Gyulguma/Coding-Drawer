import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0; i < repeat; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0) stack.pop();
            else stack.push(number);
        }
        int result = 0;
        for(int number : stack){
            result += number;
        }
        System.out.println(result);
    }
}