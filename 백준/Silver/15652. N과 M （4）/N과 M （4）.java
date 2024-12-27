import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        recursion(m, 0, "", 0);
        System.out.println(sb.toString().trim());
    }

    private static void recursion(final int cutLine, int length, String result, int start) {
        if(length == cutLine){
            sb.append(result.trim()).append("\n");
            return;
        }
        for(int i=start; i<arr.length; i++){
            recursion(cutLine, length+1, result + arr[i] + " ", i);
        }

    }
}
