import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(String operation : operations) {
            if(operation.equals("D 1")) {
                minHeap.remove(maxHeap.poll());
                continue;
            }
            if(operation.equals("D -1")) {
                maxHeap.remove(minHeap.poll());
                continue;
            }
            
            int number = Integer.parseInt(operation.split(" ")[1]);
            minHeap.offer(number);
            maxHeap.offer(number);
        }
        
        if(minHeap.isEmpty()) return new int[]{0,0};
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}