import java.io.*;
import java.util.*;

public class Main {
	private static int result = Integer.MAX_VALUE;
	private static int n, m;
	private static List<int[]> houses;
	private static List<int[]> chickens;
	private static boolean[] visited;
	private static Set<Integer> set;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		int a = Integer.parseInt(st.nextToken());
        		if(a == 1) houses.add(new int[] {i,j});
        		else if(a== 2) chickens.add(new int[] {i,j});
        	}
        }
        
        set = new HashSet<>();
        visited = new boolean[chickens.size()];
        backtracking(0, 0);
        
        System.out.println(result);
    }
    
    private static void backtracking(int start, int count) {
    	if(count == m) {
    		int total = 0;
    		for(int i=0; i<houses.size(); i++) {
    			if(total > result) return;
    			
    			int min = Integer.MAX_VALUE;
    			int[] house = houses.get(i);
    			for(int index : set) {
        			int[] chicken = chickens.get(index);
        			int dist = Math.abs(house[0]-chicken[0]) + Math.abs(house[1]-chicken[1]);
        			min = Math.min(min, dist);
        			if(min == 1) break;
        		}
    			total += min;
    		}
    		
    		result = Math.min(result, total);
    		return;
    	}
    	
    	for(int i=start; i<chickens.size(); i++) {
    		if(visited[i]) continue;
    		visited[i] = true;
    		set.add(i);
    		backtracking(i+1, count+1);
    		set.remove(i);
    		visited[i] = false;
    	}
    }
}
