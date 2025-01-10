import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Program> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.add(new Program(i, priorities[i]));
        }
        
        int result = 0;
        while(!queue.isEmpty()){
            Program program = queue.poll();
            for(Program temp : queue){
                if(temp.priority > program.priority) {
                    queue.add(program);
                    program = null;
                    break;
                }
            }
            if(program == null) continue;
            result++;
            if(program.location == location) break;
        }
        return result;
    }
    
    private class Program {
        int location;
        int priority;
        
        public Program(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
}