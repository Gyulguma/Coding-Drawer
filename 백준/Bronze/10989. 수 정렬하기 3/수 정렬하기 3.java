import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int temp : result){
            sb.append(temp+"\n");
        }
        System.out.println(sb.toString());
    }
}