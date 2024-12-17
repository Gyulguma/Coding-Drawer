import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<String>();
        int count = 0;
        for (int i = 0; i < repeat; i++) {
            String input = br.readLine();
            if(input.equals("ENTER")) {
                set.clear();
                continue;
            }
            if(set.add(input)) {
                count++;
            }
        }
        System.out.println(count);
    }
}