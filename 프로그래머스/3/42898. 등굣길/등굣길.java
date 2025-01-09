/*
2,2:
2,1 + 1,2

f(n,m) = f(n-1,m)+f(n,m-1);
*/

class Solution {
    private static long MOD = 1000000007;
    public long solution(int m, int n, int[][] puddles) {
        long answer = 0;
        long[][] map = new long[n+1][m+1];
        // 웅덩이 표시
        for(int[] puddle : puddles){
            map[puddle[1]][puddle[0]] = -1;
        }
        
        answer = find(map, n, m);
        
        
        return answer%MOD;
    }
    
    private long find(long[][] map, int n, int m){
        // 지도 밖이거나 웅덩이면 0 반환
        if(n <= 0 || m <= 0) return 0;
        if(map[n][m] == -1) return 0;
        
        // 시작점이면 1반환
        if(n == 1 && m == 1) return 1;
        // 값이 적혀있으면 그거 반환
        if(map[n][m] != 0) return map[n][m];
        // 안 적혀있으면 저장하고 그거 반환
        return map[n][m] = (find(map, n-1, m) + find(map, n, m-1)) % MOD;
    }
}