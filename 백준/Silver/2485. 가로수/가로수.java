import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//todo 각 차이를 구한다
		int repeat = sc.nextInt();
		int[] between = new int[repeat-1];
		int first = sc.nextInt();
		int pre = first;
		for(int i=1; i<repeat; i++){
			int point = sc.nextInt();
			between[i-1] = point-pre;
			pre = point;
		}
		//todo 각 차이의 최대공약수를 구한다(유클리드 호제법)
		Arrays.sort(between);
		for(int i=between.length-1; i>0; i--){
			int a = between[i];
			int b = between[i-1];
			while(!(b==0)){
				int temp = a;
				a=b;
				b=temp%b;
			}
			between[i-1] = a;
		}
		int result = between[0];
		//todo 입력값을 set에 넣고 없는 값들의 수를 출력한다
		int count = (pre-first)/result+1 - repeat;
		System.out.println(count);
	}
	private static int gcd(int a, int b){
		while(!(b==0)){
			int temp = a;
			a=b;
			b=temp%b;
		}
		return a;
	}
}