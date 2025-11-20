import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(char c : word.toCharArray()) {
        	if(c > 'Z') {
        		sb.append((char)(c-'a'+'A') +"");
        		continue;
        	}
        	sb.append((char)(c-'A'+'a')+"");
        }
        
        System.out.println(sb.toString());
    }
}