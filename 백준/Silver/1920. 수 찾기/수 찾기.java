import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			set.add(sc.nextInt());
		}
		n=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++){
			if(set.contains(sc.nextInt()))
				sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		System.out.println(sb);
	}
}
