import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static int[][] map;
	private static int min = Integer.MAX_VALUE;
	private static List<int[]> cctvs;
	
	private static int[][][] ds1 = {{{0,1}},{{1,0}},{{0,-1}},{{-1,0}}};
	private static int[][][] ds2 = {{{0,-1},{0,1}},{{-1,0},{1,0}}};
	private static int[][][] ds3 = {{{-1,0},{0,1}},{{0,1},{1,0}},{{1,0},{0,-1}},{{0,-1},{-1,0}}};
	private static int[][][] ds4 = {{{0,-1},{-1,0},{0,1}},{{-1,0},{0,1},{1,0}},{{0,1},{1,0},{0,-1}},{{1,0},{0,-1},{-1,0}}};
	private static int[][][] ds5 = {{{-1,0},{0,1},{1,0},{0,-1}}};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        cctvs = new ArrayList<>();
        map = new int[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 6 || map[i][j] == 0) continue;
        		cctvs.add(new int[] {map[i][j], i, j, 0});
        	}
        }
        
        recur(0);
        
        System.out.println(min);
    }
    
    private static void recur(int index) {
    	if(index == cctvs.size()) {
    		int count = counting();
    		min = Math.min(min, count);
    		return;
    	}
    	int[] cctv = cctvs.get(index);
    	int type = cctv[0];
    	
    	if(type == 1 || type == 3 || type == 4) {
    		cctv[3] = 0;
    		recur(index+1);
    		
    		cctv[3] = 1;
    		recur(index+1);
    		
    		cctv[3] = 2;
    		recur(index+1);
    		
    		cctv[3] = 3;
    		recur(index+1);
    	}
    	if(type == 2) {
    		cctv[3] = 0;
    		recur(index+1);
    		
    		cctv[3] = 1;
    		recur(index+1);
    	}
    	if(type == 5) {
    		recur(index+1);
    	}
    }

	private static int counting() {
		boolean[][] bmap = new boolean[n][m];
		for(int[] cctv : cctvs) {
			if(cctv[0] == 1) setting(bmap, cctv, ds1);
			else if(cctv[0] == 2) setting(bmap, cctv, ds2);
			else if(cctv[0] == 3) setting(bmap, cctv, ds3);
			else if(cctv[0] == 4) setting(bmap, cctv, ds4);
			else setting(bmap, cctv, ds5);
		}
		
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!bmap[i][j] && map[i][j] == 0) count++;
			}
		}
		
		return count;
	}

	private static void setting(boolean[][] bmap, int[] cctv, int[][][] ds) {
		int[][] d = ds[cctv[3]];

		for(int i=0; i<d.length; i++) {
			int x = cctv[1];
			int y = cctv[2];
			while(x>=0 && x<n && y>=0 && y<m) {
				if(map[x][y] == 6) break;
				bmap[x][y] = true;
				x += d[i][0];
				y += d[i][1];
			}
		}
	}

}
