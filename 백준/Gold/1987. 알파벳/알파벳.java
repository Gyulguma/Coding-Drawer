import java.io.*;
import java.util.*;

public class Main {
	private static int r,c;
	private static char[][] map;
	private static boolean[][] visited;
	private static int result = 1;
	private static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        for(int i=0; i<r; i++) {
        	String line = br.readLine();
        	for(int j=0; j<c; j++) {
        		map[i][j] = line.charAt(j);
        	}
        }
        
        visited = new boolean[r][c];
        dfs(0, 0, 1, map[0][0]+"");
        
        System.out.println(result);
    }
    
    private static void dfs(int x, int y, int count, String current) {
    	for(int i=0; i<d.length; i++) {
    		int nx = x + d[i][0];
    		int ny = y + d[i][1];
    		if(nx<0 || nx>=r || ny<0 || ny>=c || visited[nx][ny] || current.contains(map[nx][ny]+"")) continue;
    		result = Math.max(result, count+1);
    		visited[nx][ny] = true;
    		dfs(nx, ny, count+1, current+map[nx][ny]);
    		visited[nx][ny] = false;
    	}
    }
}