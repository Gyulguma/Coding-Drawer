import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lastNumber = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        for(String token : tokens) {
            queue.add(Integer.parseInt(token));
        }
        int current = 1;
        while(current <= lastNumber){
            if(queue.isEmpty()){
                break;
            }
            if(queue.peek() == current){
                queue.poll();
                current++;
                continue;
            }
            if(stack.isEmpty() || stack.peek() != current){
                stack.push(queue.poll());
                continue;
            }
            stack.pop();
            current++;
        }
        while(!stack.isEmpty()) {
            if(stack.pop() == current) {
                current++;
                continue;
            }
            System.out.println("Sad");
            return;
        }
        System.out.println("Nice");
    }
}
