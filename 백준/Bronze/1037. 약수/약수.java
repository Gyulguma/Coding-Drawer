import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);
        System.out.println(numbers[0]*numbers[n-1]);
    }
}