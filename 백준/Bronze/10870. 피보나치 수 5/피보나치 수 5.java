import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = fibonachi(n);
        System.out.println(result);
    }

    private static int fibonachi(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return fibonachi(n-1) + fibonachi(n-2);
    }
}