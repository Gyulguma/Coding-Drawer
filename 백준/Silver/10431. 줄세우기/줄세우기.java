import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int repeat = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test=1; test<=repeat; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<>();
			list.add(Integer.parseInt(st.nextToken()));
			
			int count = 0;
			T: for(int i=1; i<20; i++) {
				int current = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<list.size(); j++) {
					if(list.get(j) < current) continue;
					count += list.size()-j;
					list.add(j, current);
					continue T;
				}
				list.add(current);
			}
			
			sb.append(number).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
	