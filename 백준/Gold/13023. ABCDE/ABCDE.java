import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static List<List<Integer>> graph;
	private static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        
        visited = new boolean[n];
        int result = 0;
        for(int i=0; i<n; i++) {
        	if(dfs(i, 1)) {
        		result = 1;
        		break;
        	}
        }
        
        System.out.println(result);
    }
    
    private static boolean dfs(int index, int count) {
    	if(count == 5) return true;
    	
    	visited[index] = true;
    	for(int i : graph.get(index)) {
    		if(visited[i]) continue;
    		if(dfs(i, count+1)) return true;
    	}
    	visited[index] = false;
    	return false;
    }
}
