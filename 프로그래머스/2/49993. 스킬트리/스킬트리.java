import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        T: for(String skillTree : skill_trees) {
            boolean[] visited = new boolean[skill.length()];
            for(char c : skillTree.toCharArray()) {
                if(!map.containsKey(c)) continue;
                int idx = map.get(c);
                if(idx > 0 && !visited[idx-1]) continue T;
                visited[idx] = true;
            }
            answer++;
        }
        
        return answer;
    }
}