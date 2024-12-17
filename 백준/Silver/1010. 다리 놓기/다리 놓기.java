import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < repeat; j++){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[0]);
            if(k > n/2) k = n-k;
            long mo = 1;
            for(int i=0; i<k; i++, n--){
                mo *= n;
            }
            long ja = 1;
            for(int i=1; i<=k; i++){
                ja *= i;
            }
            sb.append(mo/ja).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}