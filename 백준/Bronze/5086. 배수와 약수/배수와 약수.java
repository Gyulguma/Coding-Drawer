import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == 0 && b == 0) {
				return;
			}
			System.out.println(check(a, b));
		}

	}
	private static String check(int a, int b){
		if(a > b && a%b == 0) return "multiple";
		else if(a < b && b%a == 0) return "factor";
		else return "neither";
	}
}
