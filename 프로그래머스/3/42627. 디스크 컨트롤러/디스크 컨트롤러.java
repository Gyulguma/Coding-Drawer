import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        List<Program> list = new ArrayList<>();
        for(int i=0; i<jobs.length; i++){
            list.add(new Program(i, jobs[i][0], jobs[i][1]));
        }
        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o1.applyTime, o2.applyTime);
        });
         
        PriorityQueue<Program> readyQueue = new PriorityQueue<>();
        List<Program> endList = new ArrayList<>();
        
        int index=0, time=0;
        while(index < jobs.length){
            while(index < jobs.length && time >= list.get(index).applyTime){
                readyQueue.offer(list.get(index++));
            }
            if(readyQueue.isEmpty()){
                time++;
            }
            else{
                Program program = readyQueue.poll();
                time += program.runTime;
                program.setEndTime(time);
                endList.add(program);
            }
        }
        
        while(!readyQueue.isEmpty()){
            Program program = readyQueue.poll();
            time += program.runTime;
            program.setEndTime(time);
            endList.add(program);
        }
        
        int total=0;
        for(Program program : endList){
            total += program.endTime - program.applyTime;
        }
        
        return total/endList.size();
    }
    
    private class Program implements Comparable<Program>{
        private int index;
        private int applyTime;
        private int runTime;
        private int endTime;
        
        public Program(int index, int applyTime, int runTime){
            this.index = index;
            this.applyTime = applyTime;
            this.runTime = runTime;
            this.endTime = 0;
        }
        
        @Override
        public int compareTo(Program p){
            if(this.runTime < p.runTime) return -1;
            if(this.runTime > p.runTime) return 1;
            if(this.applyTime < p.applyTime) return -1;
            if(this.applyTime > p.applyTime) return 1;
            if(this.index < p.index) return -1;
            if(this.index > p.index) return 1;
            return 0;
        }
        
        @Override
        public String toString(){
            return Integer.toString(this.index);
        }
        
        public void setEndTime(int time){
            this.endTime = time;
        }
    }
}