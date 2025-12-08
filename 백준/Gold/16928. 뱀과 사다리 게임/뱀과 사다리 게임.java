import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int ladder = Integer.parseInt(st.nextToken());
    	int snake = Integer.parseInt(st.nextToken());
    	
    	Map<Integer, Integer> moveInfo = new HashMap<>();
    	for(int i=0; i<ladder+snake; i++) {
    		st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	moveInfo.put(x, y);
    	}
    	
    	//[point, count]
    	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
    		if(o1[1] == o2[1]) return -Integer.compare(o1[0], o2[0]);
    		return Integer.compare(o1[1], o2[1]);
    	});
    	
    	pq.offer(new int[] {1,0});
    	
    	boolean[] visited = new boolean[101];
    	while(!pq.isEmpty()) {
    		int[] info = pq.poll();
    		int point = info[0];
    		int count = info[1];
    		
    		if(point == 100) {
    			System.out.println(count);
    			return;
    		}
    		
    		visited[point] = true;
    		
    		for(int i=1; i<=6; i++) {
    			int npoint = point + i;
    			if(npoint > 100) break;
    			
    			
    			if(moveInfo.containsKey(npoint)) {
    				npoint = moveInfo.get(npoint);
    			}
    			
    			if(visited[npoint]) continue;
    			pq.offer(new int[] {npoint, count+1});
    		}
    	}
    	System.out.println(-1);
    	
    }
}
