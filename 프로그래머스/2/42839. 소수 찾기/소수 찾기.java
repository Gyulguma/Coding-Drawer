import java.util.*;

class Solution {
    private boolean[] visited = new boolean[7];
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++){
            dfs(numbers, "", 1);
        }
        
        for(int number : set){
            if(check(number)) answer++;
        }
        return answer;
    }
    
    private void dfs(String numbers, String s, int depth){
        // base condition
        if(depth > numbers.length()) return;
        
         for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean check(int number){
        if(number <2) return false;
        for(int i=2; i<=number/2;i++){
            if(number%i == 0) return false;
        }
        return true;
    }
}