import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input =sc.next();
		int formation = sc.nextInt();
		int result = 0;
		for(int i=0; i<input.length(); i++){
			char temp = input.charAt(input.length()-1-i);
			if(temp >= 65)
				result += Math.pow(formation, i) * (temp-55);
			else
				result += Math.pow(formation, i) * (temp-48);
		}
		System.out.println(result);
		sc.close();
	}
}
