import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nm = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<String> set = new HashSet<>();

        for(int i=0; i<nm[0]; i++){
            set.add(br.readLine());
        }
        int result = 0;
        for(int i=0; i<nm[1]; i++){
            if(set.contains(br.readLine())) result++;
        }

        System.out.println(result);
    }


}