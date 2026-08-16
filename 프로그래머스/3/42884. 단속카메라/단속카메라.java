import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        for(int[] route : routes) System.out.print(Arrays.toString(route));
        
        boolean[] visited = new boolean[routes.length];
        
        for(int i=0; i<routes.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            for(int j=i+1; j<routes.length; j++) {
                if(visited[j]) continue;
                if(routes[i][1] < routes[j][0]) break;
                visited[j] = true;
            }
            answer++;
        }
        
        return answer;
    }
}