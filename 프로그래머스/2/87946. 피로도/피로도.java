class Solution {
    static boolean[] visited;
    static int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return result;
    }
    
    private void dfs(int[][] dungeons, int k, int depth){
        for(int i=0; i<dungeons.length; i++){
            if(visited[i] == true || k < dungeons[i][0]){
                continue;
            }
            visited[i] = true;
            dfs(dungeons, k - dungeons[i][1], depth+1);
            visited[i] = false;
        }
        this.result = Math.max(this.result, depth);
    }
}