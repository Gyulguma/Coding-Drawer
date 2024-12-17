import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < repeat; i++) {
            String[] inputs = br.readLine().split(" ");
            String a = inputs[0];
            String b = inputs[1];
            if(!set.contains(a) && !set.contains(b)) {
                continue;
            }
            set.add(a);
            set.add(b);
        }
        System.out.println(set.size());
    }
}