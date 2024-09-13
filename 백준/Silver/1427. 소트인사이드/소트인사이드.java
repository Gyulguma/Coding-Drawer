import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int[] result = Stream.of(target.split("")).mapToInt(Integer::parseInt).toArray();
        Integer[] result2 = Arrays.stream(result).boxed().toArray(Integer[]::new);
        Arrays.sort(result2, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int a : result2){
            sb.append(a);
        }
        System.out.println(sb.toString());
    }
}