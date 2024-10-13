import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<>();
		int n= sc.nextInt();
		int m =sc.nextInt();
		List<String> list = new ArrayList<>();
		for(int i=0; i<n; i++){
			String name = sc.next();
			set.add(name);
		}
		for(int i=0; i<m; i++){
			String name = sc.next();
			if(set.contains(name)) list.add(name);
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()+"\n");
		for(String name : list){
			sb.append(name+"\n");
		}
		System.out.println(sb.toString());
	}
}