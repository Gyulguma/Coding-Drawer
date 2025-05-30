import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        int aGoal = Integer.parseInt(st.nextToken());
        int bGoal = Integer.parseInt(st.nextToken());
        
        boolean[][] visited = new boolean[aSize+1][bSize+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.offer(new int[] {0,0,0});
        
        while(!pq.isEmpty()) {
        	int[] info = pq.poll();
        	int a = info[0];
        	int b = info[1];
        	int count = info[2];
        	
        	if(a == aGoal && b == bGoal) {
        		System.out.println(count);
        		return;
        	}

        	if(visited[a][b]) continue;
        	visited[a][b] = true;
        	
        	pq.offer(new int[] {aSize, b, count+1});
        	pq.offer(new int[] {a, bSize, count+1});
        	pq.offer(new int[] {0, b, count+1});
        	pq.offer(new int[] {a, 0, count+1});
        	
        	int newA = 0;
        	int newB = 0;
        	if(a <= bSize-b) {
        		newA = 0;
        		newB = b+a;
        	}else {
        		newA = a - (bSize-b);
        		newB = bSize;
        	}
        	pq.offer(new int[] {newA, newB, count+1});
        	
        	newA = 0;
        	newB = 0;
        	if(b <= aSize-a) {
        		newB = 0;
        		newA = b+a;
        	}else {
        		newB = b - (aSize-a);
        		newA = aSize;
        	}
        	pq.offer(new int[] {newA, newB, count+1});
        	
        }
        
        System.out.println(-1);
    }
}
