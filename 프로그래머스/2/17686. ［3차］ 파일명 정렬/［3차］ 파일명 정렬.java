import java.util.*;

class Solution {
    private class FileName implements Comparable<FileName> {
        String filename;
        String head;
        long num;
        
        public FileName(String filename) {
            this.filename = filename;
            StringBuilder sb1 = new StringBuilder();
            int idx = 0;
            while(filename.charAt(idx) < '0' || filename.charAt(idx) > '9') {
                sb1.append(filename.charAt(idx++));
            }
            this.head = sb1.toString().toLowerCase();
            
            StringBuilder sb2 = new StringBuilder();
            while(idx < filename.length() && filename.charAt(idx) >= '0' && filename.charAt(idx) <= '9') {
                sb2.append(filename.charAt(idx++));
            }
            this.num = Long.parseLong(sb2.toString());
        }
        
        @Override
        public int compareTo(FileName o) {
            if(!this.head.equals(o.head)) return this.head.compareTo(o.head);
            if(this.num != o.num) return Long.compare(this.num, o.num);
            return 0;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileName> list = new ArrayList<>();
        for(String file : files) {
            list.add(new FileName(file));
        }
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).filename;
        }
        return answer;
    }
}