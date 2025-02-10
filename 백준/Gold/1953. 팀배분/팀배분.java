import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static boolean[] visited;
	private static int[][] graph;
	private static int[] teams;
	private static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		//init
		visited = new boolean[n+1];
		graph = new int[n+1][n+1];
		teams = new int[n+1];
	
		//input
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			for(int j=0; j<repeat; j++) {
				graph[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		
		//solution
		for(int i=1; i<=n; i++) {
			if(teams[i] == 0) {
				dfs(i, 1);
			}
		}
		
		//output
		setTeam(1);
		setTeam(-1);
		System.out.println(sb);
	}

	private static void setTeam(int team) {
		int count = 0;
		for(int i=1; i<=n; i++) {
			if(teams[i] != team) continue;
			count++;
		}
		sb.append(count).append("\n");
		for(int i=1; i<=n; i++) {
			if(teams[i] != team) continue;
			sb.append(i).append(" ");
		}
		sb.append("\n");
	}

	private static void dfs(int start, int teamColor) {
		if(teams[start] == 0) {
			teams[start] = teamColor;
			for(int i=1; i<=n; i++) {
				if(graph[start][i] == 0) continue;
				dfs(i, teamColor*-1);
			}
		}
	}
}
