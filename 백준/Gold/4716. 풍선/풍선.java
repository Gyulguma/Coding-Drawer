import java.io.*;
import java.util.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int n, a, b;
	private static class Team implements Comparable<Team>{
		int need;
		int disA;
		int disB;
		
		public Team(int need, int disA, int disB) {
			this.need = need;
			this.disA = disA;
			this.disB = disB;
		}
		
		@Override
		public int compareTo(Team o) {
			return Math.abs(o.disA - o.disB) - Math.abs(this.disA - this.disB);
		}
		
		@Override
		public String toString() {
			return "["+need+","+disA+","+disB+"]";
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(n == 0 && a == 0 && b == 0) break;
			
			Team[] teams = new Team[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				teams[i] = new Team(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			solution(teams);
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void solution(Team[] teams) {
		Arrays.sort(teams);
		
		long result = 0;
		for(int i=0; i<n; i++) {
			Team team = teams[i];
			
			int rest = team.need;
			if(team.disA >= team.disB) {
				if(b >= rest) {
					result += rest*team.disB;
					b -= rest;
				}
				else {
					result += b*team.disB;
					rest -= b;
					b = 0;
					result += rest*team.disA;
					a -= rest;
				}
			}
			else {
				if(a >= rest) {
					result += rest*team.disA;
					a -= rest;
				}
				else {
					result += a*team.disA;
					rest -= a;
					a = 0;
					result += rest*team.disB;
					b -= rest;
				}
			}
		}
		
		sb.append(result).append("\n");
	}
	
}
	