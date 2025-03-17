import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int oper = Integer.parseInt(br.readLine());
            if(oper != 0){
                pq.offer(oper);
                continue;
            }
            if(pq.isEmpty()){
                System.out.println(0);
                continue;
            }
            System.out.println(pq.poll());
        }
    }
}