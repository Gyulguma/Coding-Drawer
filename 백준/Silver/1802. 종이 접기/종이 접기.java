import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		T: for(int t=0; t<test; t++) {
			String info = br.readLine();
			while(info.length() > 1) {
				String front = info.substring(0, info.length()/2);
				String back = info.substring(info.length()/2+1, info.length());
				
				StringBuilder sb2 = new StringBuilder();
				for(int i=front.length()-1; i>=0; i--) {
					sb2.append(front.charAt(i)=='0' ? "1" : "0");
				}
				
				if(!sb2.toString().equals(back)) {
					sb.append("NO").append("\n");
					continue T;
				}
				info = front;
			}
			
			sb.append("YES").append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
	