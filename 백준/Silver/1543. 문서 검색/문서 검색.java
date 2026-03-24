import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String document = br.readLine();
		String word = br.readLine();
		
		int count = 0;
		int i=0;
		int j=0;
		while(i<document.length()) {
			if(document.charAt(i) != word.charAt(j)) {
				i++;
				continue;
			}
			
			int start = i;
			while(start<document.length() && j<word.length()) {
				if(document.charAt(start) != word.charAt(j)) break;
				start++;
				j++;
			}
			if(j == word.length()) {
				count++;
				i = start;
			}
			else i++;
			j=0;
		}
		
		System.out.println(count);
	}
	
}
	