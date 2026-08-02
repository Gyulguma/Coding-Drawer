import java.util.*;

class Solution {
    
    private class Info implements Comparable<Info>{
        int totalTime;
        int inTime;
        int number;
        
        public Info(int number) {
            this.totalTime = 0;
            this.inTime = -1;
            this.number = number;
        }
        
        public void process(int time, String status) {
            if("IN".equals(status)) {
                inTime = time;
                return;
            }
            
            totalTime += time - inTime;
            inTime = -1;
        }
        
        @Override
        public int compareTo(Info o) {
            return this.number - o.number;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Info> map = new HashMap<>();
        
        for(String record : records) {
            String[] infos = record.split(" ");
            
            String[] times = infos[0].split(":");
            int time = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
            
            int number = Integer.parseInt(infos[1]);
            
            Info info = map.getOrDefault(number, new Info(number));
            info.process(time, infos[2]);
            map.put(number, info);
        }
        
        List<Info> list = new ArrayList<>(map.values());
        Collections.sort(list);
        
        int lastTime = 23*60 + 59;
        for(int i=0; i<list.size(); i++) {
            Info info = list.get(i);
            if(info.inTime != -1) {
                info.totalTime += lastTime - info.inTime;
            }
            
            int fee = fees[1];
            if(info.totalTime > fees[0]) {
                int left = info.totalTime - fees[0];
                fee += left%fees[2] == 0 ? (left/fees[2]) * fees[3] : (left/fees[2] + 1) * fees[3];
            }
            
            result.add(fee);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}