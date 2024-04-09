import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat  = sc.nextInt();
		sc.nextLine();
		String numbers = sc.nextLine();
		int count = repeat;
		for(int i=0; i<repeat; i++){
			int number = Integer.parseInt(numbers.split(" ")[i]+"");
			if(number == 1) count--;
			for(int j=2; j< number; j++){
				if(number % j == 0){
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
