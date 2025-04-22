import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 1. 집에 있는 모든 온풍기에서 바람이 한 번 나옴
	 * 2. 온도가 조절됨
	 * 3. 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
	 * 4. 초콜릿을 하나 먹는다.
	 * 5. 조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.
	 * */
	
	private static int r, c, k;
	private static int[][] map;
	private static List<int[]> target = new ArrayList<>();
	private static List<int[]> machines = new ArrayList<>();
	private static int[][][] machineDir = {{}, 
			{{-1,1},{0,1},{1,1}}, //오른쪽
			{{-1,-1},{0,-1},{1,-1}},//왼쪽
			{{-1,-1},{-1,0},{-1,1}},//위
			{{1,-1},{1,0},{1,1}}};//아래
	private static int[][][] checkWall = {{}, 
			{{0,3},{1},{2,3}}, //오른쪽
			{{0,1},{3},{2,1}},//왼쪽
			{{3,2},{0},{1,2}},//위
			{{3,0},{2},{1,0}}};//아래
	//0이면 위에, 1이면 오른쪽에 벽이 있음
	private static Set<String> wallSet = new HashSet<>();
	private static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<r; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<c; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		if(num == 5) target.add(new int[] {i, j});
        		else if(num > 0) machines.add(new int[] {i, j, num});
        	}
        }
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken())-1;
        	int y = Integer.parseInt(st.nextToken())-1;
        	int dir = Integer.parseInt(st.nextToken());
        	
        	wallSet.add(x+" "+y+" "+dir);
        	
        	int nx = x+d[dir][0];
        	int ny = y+d[dir][1];
        	if(OOB(nx, ny)) continue;
        	
        	if(dir == 0) wallSet.add(nx+" "+ny+" "+2);
        	else wallSet.add(nx+" "+ny+" "+3);
        }
        
        map = new int[r][c];
        int count = 0;
        while(true) {
        	turnOn();
        	tempControl();
        	edgeDown();
        	count++;
        	if(checkTemp()) break;
        	if(count == 101) break;
        }

//        printMap();
        System.out.println(count);
    }

    private static void printMap() {
    	System.out.println("------------Map------------");
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	//집에 있는 모든 온풍기에서 바람이 한 번 나옴
    private static void turnOn() {
		for(int[] machine : machines) {
			int x = machine[0];
			int y = machine[1];
			int[][] dir = machineDir[machine[2]];
			int[][] wall = checkWall[machine[2]];
			
			int nx = x + dir[1][0];
			int ny = y + dir[1][1];
			if(OOB(nx, ny)) continue;
			
			boolean[][] visited = new boolean[r][c];
			Queue<int[]> q = new LinkedList<>();
			
			q.offer(new int[] {nx, ny, 5});
			map[nx][ny] += 5;
			visited[nx][ny] = true;
			
			while(!q.isEmpty()) {
				int[] info = q.poll();
				
				x = info[0];
				y = info[1];
				int up = info[2];
				
				if(up <= 1) break;
				
				//dir: {{1,-1},{1,0},{1,1}}};//아래
				//wall: {{3,0},{2},{1,0}}};//아래
				for(int i=0; i<dir.length; i++) {
					nx = x + dir[i][0];
					ny = y + dir[i][1];
					if(OOB(nx, ny) || visited[nx][ny]) continue;
					if(i != 1) {
						if(wallSet.contains(x+" "+y+" "+wall[i][0])) continue;
						if(wallSet.contains(nx+" "+ny+" "+wall[i][1])) continue;
					}
					else if(wallSet.contains(x+" "+y+" "+wall[i][0])) continue;
					
					q.offer(new int[] {nx, ny, up-1});
					map[nx][ny] += up-1;
					visited[nx][ny] = true;
				}
			}
		}
		
	}

	//온도가 조절됨
    private static void tempControl() {
		int[][] temp = new int[r][c];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				int temper = map[i][j];
				temp[i][j] += temper;
				for(int idx=0; idx<d.length; idx++) {
					if(wallSet.contains(i+" "+j+" "+idx)) continue;
					int nx = i+d[idx][0];
					int ny = j+d[idx][1];
					if(OOB(nx, ny) || map[nx][ny] >= temper) continue;
					int decre = (temper-map[nx][ny])/4;
					temp[nx][ny] += decre;
					temp[i][j] -= decre;
				}
			}
		}
		
		map = temp;
	}

	//온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
	private static void edgeDown() {
		//좌우
		for(int i=0; i<r; i++) {
			if(map[i][0] >= 1) map[i][0]--;
			if(map[i][c-1] >= 1) map[i][c-1]--;
		}
		
		//상하
		for(int j=1; j<c-1; j++) {
			if(map[0][j] >= 1) map[0][j]--;
			if(map[r-1][j] >= 1) map[r-1][j]--;
		}
	}

	//조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단
	private static boolean checkTemp() {
		for(int[] point : target) {
			if(map[point[0]][point[1]] < k) return false;
		}
		
		return true;
	}
	
	private static boolean OOB(int x, int y) {
		if(x<0 || x>=r || y<0 || y>=c) return true;
		return false;
	}
}
