import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        Map<String, Integer> xTerms = new HashMap<>();
        for(String temp : terms){
            xTerms.put(temp.split(" ")[0], Integer.parseInt(temp.split(" ")[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            if(check(privacy[0], today, xTerms.get(privacy[1]))) result.add(i+1);     
        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    private boolean check(String target, String today, int period){
        int[] xToday = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] xTarget = Arrays.stream(target.split("\\.")).mapToInt(Integer::parseInt).toArray();
        
        return ((xToday[0]-xTarget[0])*12*28) + ((xToday[1]-xTarget[1])*28) + (xToday[2]-xTarget[2]) >= period*28;
    }
}