import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int[] numbers;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        numbers = new int[n];
        visited = new boolean[n];
        sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }
        String result = "";
        dfs(m, 0, 0, result);

        System.out.println(sb.toString().trim());
    }

    private static void dfs(int m, int start, int length, String result) {
        if(length >= m) {
            sb.append(result.trim()).append("\n");
            return;
        }
        for(int i=start; i<numbers.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(m, i, length+1, result + numbers[i] + " ");
            visited[i] = false;
        }
    }
}