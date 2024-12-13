import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
            String instruction = br.readLine();
            int operator = 0;
            int operand = 0;
            if(instruction.contains("1")){
                operator = Integer.parseInt(instruction.split(" ")[0]);
                operand = Integer.parseInt(instruction.split(" ")[1]);
            }
            else operator = Integer.parseInt(instruction);
            int number = -1;
            switch(operator){
                case 1:
                    stack.push(operand);
                    break;
                case 2:
                    number = stack.isEmpty() ? -1 : stack.pop();
                    break;
                case 3:
                    number = stack.size();
                    break;
                case 4:
                    number = stack.isEmpty() ? 1 : 0;
                    break;
                case 5:
                    number = stack.isEmpty() ? -1 : stack.peek();
                    break;
            }
            if(operator==1) continue;
            System.out.println(number);
        }
    }
}