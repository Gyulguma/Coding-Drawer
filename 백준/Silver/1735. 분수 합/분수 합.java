import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sonA = sc.nextInt();
		int momA = sc.nextInt();
		int sonB = sc.nextInt();
		int momB = sc.nextInt();

		int sonResult = (momA*sonB)+(momB*sonA);
		int momResult = momA*momB;

		int n=2;
		while(!(sonResult < n || momResult < n)){
			if(sonResult%n==0 && momResult%n==0){
				sonResult /= n;
				momResult /= n;
				n=2;
			}
			else n++;
		}

		System.out.println(sonResult+" "+momResult);
	}
}