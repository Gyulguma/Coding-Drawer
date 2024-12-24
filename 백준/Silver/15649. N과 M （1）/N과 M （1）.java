import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static boolean[] visited;
    private static int[] numbers;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        sb = new StringBuilder();
        visited = new boolean[n];
        numbers = new int[n];

        for(int i=1; i<=n; i++){
            numbers[i-1] = i;
        }
        String result = "";
        dfs(numbers, m, result, 0);
        System.out.println(sb.toString().trim());
    }

    private static void dfs(final int[] numbers, final int m, String result, int length){
        if(length >= m){
            sb.append(result.toString().trim()).append("\n");
            return;
        }
        for(int i=0; i<numbers.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numbers, m, result + numbers[i]+ " ", length+1);
            visited[i] = false;
        }
    }
}