import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		Carrot[] farm = new Carrot[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			farm[i] = new Carrot(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(farm);
		
		long result = 0;
		int growDay = t-n;
		for(int i=0; i<n; i++) {
			result += farm[i].start + (long)(farm[i].growUp)*growDay++;
		}
		
		System.out.println(result);
	}
	
	private static class Carrot implements Comparable<Carrot>{
		private int num;
		private int start;
		private int growUp;
		
		public Carrot(int num, int start, int growUp) {
			this.num = num;
			this.start = start;
			this.growUp = growUp;
		}
		
		@Override
		public int compareTo(Carrot other) {
			return Integer.compare(this.growUp, other.growUp);
		}
	}
}