import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String[] strArray = new String[S.length()];

        for(int i = 0; i < S.length(); i++) {
            strArray[i] = S.substring(i, S.length());
        }

        Arrays.sort(strArray);

        for(String str : strArray) {
            System.out.println(str);
        }

    }
}