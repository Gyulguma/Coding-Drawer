import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int min = Integer.parseInt(inputs[0]);
        int max = Integer.parseInt(inputs[0]);
        for(int i = 0; i<n; i++){
            int number = Integer.parseInt(inputs[i]);
            if(min > number) min = number;
            if(max < number) max = number;
        }
        System.out.println(min*max);
    }
}