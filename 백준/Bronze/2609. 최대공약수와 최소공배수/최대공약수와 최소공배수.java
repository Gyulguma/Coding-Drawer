import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int maxNum = gcd(num1, num2); //최대공약수
		
		bw.write(maxNum+"\n");
		bw.write(num1*num2/maxNum+"");
		bw.flush();
		bw.close();
		
	}
	
	public static int gcd(int num1, int num2) {
		if(num2 == 0)
			return num1;
		return gcd(num2, num1 % num2);
	}
}