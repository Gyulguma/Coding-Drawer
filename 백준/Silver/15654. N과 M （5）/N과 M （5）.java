import java.io.*;
import java.util.*;

public class Main {
	private static int[] num;
	private static StringBuilder sb = new StringBuilder();
	private static int n,m;
	private static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num);
        visited = new boolean[n];
        dfs(0, "");
        System.out.println(sb.toString().trim());
        
    }
    
    private static void dfs(int dept, String current) {
    	if(dept == m) {
    		sb.append(current).append("\n");
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
    		if(visited[i]) continue;
    		visited[i] = true;
    		dfs(dept+1, current+num[i]+" ");
    		visited[i] = false;
    	}
    }
}
