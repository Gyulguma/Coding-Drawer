import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++){
            String[] input = br.readLine().split(" ");
            int operator, operand = 0;
            operator = Integer.parseInt(input[0]);
            if(input.length == 2) operand = Integer.parseInt(input[1]);
            switch(operator){
                case 1:
                    deque.addFirst(operand);
                    break;
                case 2:
                    deque.addLast(operand);
                    break;
                case 3:
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;
                case 4:
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case 7:
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;
                case 8:
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString().trim());
    }
}
