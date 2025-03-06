import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[r][c];
        int cheese = 0;
        for(int i=0; i<r; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<c; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) cheese++;
        	}
        }
        
        boolean[][] air = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        air[0][0] = true;
        
        int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()) {
        	int[] point = queue.poll();
        	for(int i=0; i<4; i++) {
        		int nx = point[0] + d[i][0];
        		int ny = point[1] + d[i][1];
        		if(nx<0 || nx>=r || ny<0 || ny>=c || air[nx][ny] || map[nx][ny] == 1) continue;
        		queue.offer(new int[] {nx,ny});
        		air[nx][ny] = true;
        	}
        }
        
        int time = 0;
        while(cheese != 0) {
        	int nextCheese = cheese;
        	
        	int count = 0;
        	//치즈 녹음
        	for(int i=0; i<r; i++) {
        		for(int j=0; j<c; j++) {
        			if(map[i][j] == 0) continue;
        			
        			for(int index=0; index<4; index++) {
        				int nx = i + d[index][0];
        				int ny = j + d[index][1];
        				if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
        				if(air[nx][ny]) {
        					map[i][j] = 0;
        					nextCheese--;
        					queue.offer(new int[] {i,j});
        					count++;
        					break;
        				}
        			}
        		}
        	}
//        	System.out.println(time+": "+count);
        	//공기 통함
        	while(!queue.isEmpty()) {
				int[] point = queue.poll();
				air[point[0]][point[1]] = true;
				for(int index=0; index<4; index++) {
    				int nx = point[0] + d[index][0];
    				int ny = point[1] + d[index][1];
    				if(nx<0 || nx>=r || ny<0 || ny>=c || air[nx][ny] || map[nx][ny] == 1) continue;
            		queue.offer(new int[] {nx,ny});
            		air[nx][ny] = true;
    			}
			}
        	
        	time++;
        	if(nextCheese == 0) break;
        	cheese = nextCheese;
        }
        
        
        System.out.println(time);
        System.out.println(cheese);
    }
}