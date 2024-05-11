import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        Map<String, Integer> reports = new HashMap<>();
        Map<String, ArrayList<String>> reportList = new HashMap<>();
        
        for(String id : id_list){
            result.add(0);
            reports.put(id, 0);
            reportList.put(id, new ArrayList<String>());
        }
        
        for(String temp : report){
            String[] ids = temp.split(" ");
            if(!reportList.get(ids[0]).contains(ids[1])) {
                reportList.get(ids[0]).add(ids[1]);
                reports.put(ids[1], reports.get(ids[1])+1);
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            if(reports.get(id_list[i]) < k) continue;
            for(int j=0; j<id_list.length; j++){
                if(reportList.get(id_list[j]).contains(id_list[i])){
                    result.set(j, result.get(j)+1);
                }
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}