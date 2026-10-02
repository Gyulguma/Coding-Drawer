import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        String[] now = today.split("\\.");
        int nowD = Integer.parseInt(now[0])*365 + Integer.parseInt(now[1])*28 + Integer.parseInt(now[2]);
        
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] date = privacies[i].split(" ")[0].split("\\.");
            int term = map.get(privacies[i].split(" ")[1]);
            
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
            month += term;
            while(month > 12) {
                month -= 12;
                year++;
            }

            int curD = year*365 + month*28 + day;
            
            if(curD <= nowD) result.add(i+1);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}