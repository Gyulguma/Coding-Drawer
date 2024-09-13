import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] pre = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> result = new HashMap<>();
        int[] pre2 = pre.clone();
        Arrays.sort(pre2);
        int index = 0;
        for(int i=0; i<n; i++){
            if(result.containsKey(pre2[i])) continue;
            result.put(pre2[i], index);
            index++;
        }
        for(int i=0; i<n; i++){
            sb.append(result.get(pre[i])+" ");
        }
        System.out.println(sb);
    }

}