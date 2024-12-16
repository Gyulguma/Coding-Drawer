import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception{
        LinkedList<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++){
            String[] instruction = br.readLine().split(" ");
            String operator = "";
            String operand = "";
            operator = instruction[0];
            if(instruction.length == 2) operand = instruction[1];

            switch(operator){
                case "push":
                    queue.add(Integer.parseInt(operand));
                    break;
                case "pop":
                    if (queue.isEmpty())
                        sb.append(-1).append("\n");
                    else {
                        sb.append(queue.getFirst()).append("\n");
                        queue.removeFirst();
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.getFirst()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString().trim());
    }
}
