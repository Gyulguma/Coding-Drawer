import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }
        
        int index=0, current=0;
        
        while(index < truck_weights.length){
            current -= bridge.poll();
            answer++;
            
            if(current + truck_weights[index] <= weight){
                bridge.offer(truck_weights[index]);
                current += truck_weights[index++];
            }
            else bridge.offer(0);
        }
        
        return answer+bridge_length;
    }
}