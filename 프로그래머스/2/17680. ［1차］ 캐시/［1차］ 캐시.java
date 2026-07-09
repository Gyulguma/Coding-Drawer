import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        for(String city : cities) {
            city = city.toLowerCase();
            if(q.isEmpty() || !q.contains(city)) answer += 5;
            else {
                answer += 1;
                q.remove(city);
            }
            q.offer(city);
            if(q.size() > cacheSize) q.poll();
        }
        
        return answer;
    }
}