import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        String[] lines = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(lines[i]);
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int index = 0;
        while(count < n){
            sb.append(index+1).append(" ");
            visited[index] = true;
            int destination = arr[index];
            int move = 0;
            while(move != destination){
                if(destination < 0){
                    index = index-1;
                    index = index < 0 ? index+n : index;
                    if(!visited[index]) move--;
                }
                else{
                    index = index+1;
                    index = index >= n ? index-n : index;
                    if(!visited[index]) move++;
                }
            }
            count++;
        }
        sb.append(index+1).append(" ");
        System.out.println(sb.toString().trim());
    }
}