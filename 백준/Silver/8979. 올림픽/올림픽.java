import java.io.*;
import java.util.*;

public class Main {
	private static class Nation implements Comparable<Nation>{
		int number;
		int gold, silver, copper;
		
		public Nation(int number, int gold, int silver, int copper) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.copper = copper;
		}
		
		@Override
		public int compareTo(Nation o) {
			if(this.gold != o.gold) return o.gold - this.gold;
			if(this.silver != o.silver) return o.silver - this.silver;
			if(this.copper != o.copper) return o.copper - this.copper;
			return 0;
		}
		
		public String toString() {
			return "["+number+" "+gold+" "+silver+" "+copper+"]";
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Nation> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Nation(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		if(list.get(0).number == k) {
			System.out.println(1);
			return;
		}
		
		int result = 2;
		int duplication = 0;
		for(int i=1; i<n; i++) {
			Nation current = list.get(i);
			Nation pre = list.get(i-1);
			if(current.gold == pre.gold
				&& current.silver == pre.silver
				&& current.copper == pre.copper) {
				duplication++;
			}
			else duplication = 0;
			
			if(current.number == k) break;
			result++;
		}
		
		System.out.println(result-duplication);
	}
}
	