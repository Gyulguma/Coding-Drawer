import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] result = new int[n][2];
        for(int i=0; i<n; i++){
            result[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(result, (o1, o2) -> {
            if(o1[0] > o2[0]) return 1;
            if(o1[0] < o2[0]) return -1;
            if(o1[1] > o2[1]) return 1;
            else return -1;
        });
        StringBuilder sb = new StringBuilder();
        for(int[] a : result){
            sb.append(a[0]+" "+a[1]+"\n");
        }
        System.out.println(sb);
    }
}