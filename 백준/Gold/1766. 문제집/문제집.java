import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        int[] pre = new int[n+1];
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            pre[b]++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        	if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
        	return Integer.compare(o1[1], o2[1]);
        });
        
        for(int i=1; i<=n; i++) {
        	pq.offer(new int[] {i, pre[i]});
        }
        
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        while(!pq.isEmpty() && set.size() < n) {
        	int[] info = pq.poll();
        	
        	if(set.contains(info[0])) continue;
        	set.add(info[0]);
        	sb.append(info[0]).append(" ");
        	
        	for(int solve : graph[info[0]]) {
        		pre[solve]--;
        		pq.offer(new int[] {solve, pre[solve]});
        	}
        	
        }
        
        
        
        System.out.println(sb.toString().trim());
        
    }
    
}
