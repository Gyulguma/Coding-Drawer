import java.io.*;
import java.util.*;
/*
 * 1. 각 노드의 strahler를 저장하는 배열 1개
 * 2. 각 노드로 들어오는 노드 번호를 저장하는 자료구조
 * */
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test=0; test<testCase; test++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        
        	int k = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int p = Integer.parseInt(st.nextToken());
        	
        	//노드의 진입차수
        	int[] count = new int[m+1];
        	//노드의 strahler 값
        	int[] strahler = new int[m+1];
        	//노드와 연결된 노드의 정보
        	List<Integer>[] graph = new ArrayList[m+1];
        	for(int i=1; i<=m; i++) {
        		graph[i] = new ArrayList<>();
        	}
        	
        	//초기화
        	for(int i=0; i<p; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		graph[a].add(b);
        		count[b]++;
        	}
        	
        	//로직
        	PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(count[o1], count[o2]));
        	for(int i=1; i<=m; i++) {
        		pq.offer(i);
        		if(count[i] == 0) {
        			strahler[i] = 1;
        		}
        	}
        	
        	while(!pq.isEmpty()) {
        		int current = pq.poll();
        		
        		for(int node : graph[current]) {
        			if(strahler[node] < strahler[current]) {
        				strahler[node] = strahler[current];
        			}
        			else if(strahler[node] == strahler[current]) {
        				strahler[node]++;
        			}
        			
        			count[node]--;
        		}
        	}
        	
        	sb.append(k).append(" ").append(strahler[m]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}
