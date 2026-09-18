class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int current, int index){
        if(index == numbers.length){
            if(current == target) answer++;
            return;
        }
        
        dfs(numbers, target, current+numbers[index], index+1);
        dfs(numbers, target, current-numbers[index], index+1);
    }
}