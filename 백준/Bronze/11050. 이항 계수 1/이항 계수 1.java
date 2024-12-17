import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int mo = 1;
        for(int i=0; i<k; i++, n--){
            mo *= n;
        }
        int ja = 1;
        for(int i=1; i<=k; i++){
            ja *= i;
        }
        System.out.println(mo/ja);
    }
}
