import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            String target = br.readLine();
            if(result.contains(target)) continue;
            result.add(target);
        }

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                if(o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String a : result){
            sb.append(a+"\n");
        }
        System.out.println(sb);
    }
}