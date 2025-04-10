import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        String pattern = br.readLine();
        
        //pi배열 생성(실패 함수)
        //pi[i] = 0~i까지의 부분 문자열에서 접두사와 접미사가 일치하는 최대 길이
        int[] pi = new int[pattern.length()];
        
        int j=0;
        for(int i=1; i<pattern.length(); i++) {
        	while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {
        		j = pi[j-1];
        	}
        	if(pattern.charAt(i) == pattern.charAt(j)) {
        		pi[i] = ++j;
        	}
        }
        
        //kmp 알고리즘 수행
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        j=0;
        for(int i=0; i<text.length(); i++) {
        	while(j>0 && text.charAt(i) != pattern.charAt(j)) {
        		j = pi[j-1];
        	}
        	if(text.charAt(i) == pattern.charAt(j)) {
        		if(j == pattern.length()-1) {
        			answer++;
        			sb.append(i-pattern.length()+2).append(" ");
        			j = pi[j];
        		}
        		else {
        			j++;
        		}
        	}
        }
        
        System.out.println(answer+"\n"+sb.toString().trim());
    }
}
