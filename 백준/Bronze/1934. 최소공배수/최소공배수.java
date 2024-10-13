import java.util.Scanner;

public class Main {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		for(int i=0; i<repeat; i++){
			int result = 1;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int number = 2;
			while(!(a < number || b < number)){
				if(a%number==0 && b%number==0){
					result *= number;
					a /= number;
					b /= number;
					number=2;
				}
				else number++;
			}
			result *= a*b;
			System.out.println(result);
		}

	}
}
