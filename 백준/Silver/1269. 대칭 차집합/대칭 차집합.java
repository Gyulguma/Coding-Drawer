import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> aSet = new HashSet<>();
		Set<Integer> bSet = new HashSet<>();
		int n= sc.nextInt();
		int m =sc.nextInt();
		for(int i=0; i<n; i++){
			int number = sc.nextInt();
			aSet.add(number);
		}
		for(int i=0; i<m; i++){
			int number = sc.nextInt();
			bSet.add(number);
		}
		int result = n+m;

		for(int number : aSet){
			if(bSet.contains(number)) result--;
		}
		for(int number : bSet){
			if(aSet.contains(number)) result--;
		}
		System.out.println(result);
	}
}