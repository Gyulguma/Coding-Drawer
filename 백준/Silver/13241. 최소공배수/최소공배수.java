import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long result = 1;
		long n = 2;
		while(!(a < n || b < n)){
			if(a%n==0 && b%n==0){
				a /= n;
				b /= n;
				result *= n;
				n=2;
			}
			else n++;
		}
		result *= a*b;
		System.out.println(result);
	}
}