import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        DoublePriorityQueue<Integer> dp = new DoublePriorityQueue<>();
        for(String operation : operations){
            String operator = operation.split(" ")[0];
            int operand = Integer.parseInt(operation.split(" ")[1]);
            
            if(operator.equals("I")) {
                dp.insert(operand);
                continue;
            }
            if(operand == 1){
                dp.removeMax();
                continue;
            }
            if(operand == -1){
                dp.removeMin();
                continue;
            }
        }
        
        if(dp.isEmpty()) return new int[]{0,0};
        return new int[]{dp.getMax(), dp.getMin()};
    }
    
    private class DoublePriorityQueue<E extends Comparable<? super E>> {
        private PriorityQueue<E> minHeap;
        private PriorityQueue<E> maxHeap;
        
        public DoublePriorityQueue(){
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }
        
        public void insert(E element){
            this.minHeap.offer(element);
            this.maxHeap.offer(element);
        }
        
        public boolean isEmpty(){
            return this.minHeap.isEmpty();
        }
        
        public void removeMin(){
            this.maxHeap.remove(this.minHeap.poll());
        }
        
        public void removeMax(){
            this.minHeap.remove(this.maxHeap.poll());
        }
        
        public E getMin(){
            return this.minHeap.peek();
        }
        
        public E getMax(){
            return this.maxHeap.peek();
        }
    }
}