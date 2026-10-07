import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for(String info : record) {
            String[] infos = info.split(" ");
            String operation = infos[0];
            String userId = infos[1];
            
            if(operation.equals("Leave")) continue;
            map.put(userId, infos[2]);
        }
        
        List<String> result = new ArrayList<>();
        for(String info : record) {
            String[] infos = info.split(" ");
            String operation = infos[0];
            String userId = infos[1];
            
            if(operation.equals("Enter")) result.add(map.get(userId)+"님이 들어왔습니다.");
            else if(operation.equals("Leave")) result.add(map.get(userId)+"님이 나갔습니다.");
        }
        
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}