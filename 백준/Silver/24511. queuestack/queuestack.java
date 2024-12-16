import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();
        String[] types = br.readLine().split(" ");
        String[] values = br.readLine().split(" ");
        for(int i = repeat-1; i >= 0; i--){
            if(types[i].equals("0")){
                queue.add(Integer.parseInt(values[i]));
            }
        }
        repeat = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < repeat; i++){
            queue.add(Integer.parseInt(numbers[i]));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++){
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}