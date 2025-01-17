class Solution {
    
    private boolean[] visited;
    private int max=Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, 0);
        return max;
    }
    
    private void dfs(int k, int[][] dungeons, int check, int count){
        if(check >= dungeons.length || k <= 0){
            max = Math.max(max, count);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]){
                continue;
            }
            if(k >= dungeons[i][0]){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, check+1, count+1);
                visited[i] = false;
            }
            visited[i] = true;
            dfs(k, dungeons, check+1, count);
            visited[i] = false;
        }
    }
}