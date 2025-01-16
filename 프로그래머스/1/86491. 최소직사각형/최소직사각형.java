class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int[] size : sizes){
            if(size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        for(int[] size : sizes){
            maxW = Math.max(maxW, size[0]);
            maxH = Math.max(maxH, size[1]);
        }
        return maxW*maxH;
    }
}