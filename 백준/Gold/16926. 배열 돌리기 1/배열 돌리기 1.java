import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//roll
		int min = Math.min(n, m);
		int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int repeat=0; repeat<r; repeat++) {
			for(int cycle=0; cycle<min; cycle++) {
				int temp = map[0+cycle][0+cycle];

				int index = 0;
				int x=0+cycle, y=0+cycle;
				while(index < 4) {
					int nx = x+d[index][0];
					int ny = y+d[index][1];
					
					if(nx == 0+cycle && ny == 0+cycle) {
						map[x][y] = temp;
						break;
					}
					
					if(nx<0+cycle || nx >=n-cycle || ny<0+cycle || ny >=m-cycle) {
						index++;
						continue;
					}
					
					map[x][y] = map[nx][ny];
					x=nx;
					y=ny;
				}
			}
		}
		
		//print
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}
