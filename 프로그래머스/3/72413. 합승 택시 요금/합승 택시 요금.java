import java.util.*;

//각각의 최단거리
//한쪽의 최단거리 경로중에 다른쪽이 포함된 경우
//나머지 하나씩 확인
class Solution {
    private int n;
    private List<int[]>[] graph;
    private int min = Integer.MAX_VALUE;
    private int[] distA, distB, distS;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares) {
            graph[fare[0]].add(new int[]{fare[1], fare[2]});
            graph[fare[1]].add(new int[]{fare[0], fare[2]});
        }
        
        distA = new int[n+1]; Arrays.fill(distA, (int)1e9);
        distB = new int[n+1]; Arrays.fill(distB, (int)1e9);
        distS = new int[n+1]; Arrays.fill(distS, (int)1e9);
        
        dijkstra(a, distA);
        dijkstra(b, distB);
        dijkstra(s, distS);
        
        for(int i=1; i<=n; i++){
            int together = distS[i];
            int toA = distA[i];
            int toB = distB[i];
            if(together >= (int)1e9 || toA >= (int)1e9 || toB>= (int)1e9) continue;
            min = Math.min(min, together + toA + toB);
        }
        
        return min;
    }
    
    private void dijkstra(int start, int[] dist) {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int current = info[0];
            int cost = info[1];
            if(visited[current]) continue;
            visited[current] = true;
            
            for(int[] node : graph[current]) {
                if(visited[node[0]]) continue;
                if(cost + node[1] >= dist[node[0]]) continue;
                dist[node[0]] = cost + node[1];
                pq.offer(new int[]{node[0], dist[node[0]]});
            }
        }
    }
}