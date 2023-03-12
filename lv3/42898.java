// 등굣길

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        
        for (int[] p : puddles) {
            map[p[1] - 1][p[0] - 1] = -1;
        }
        map[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (map[i][j] == -1) continue;
                
                if(i - 1 >= 0 && map[i - 1][j] != -1) {
                    map[i][j] = (map[i][j] + map[i - 1][j]) % 1_000_000_007;                 
                }
                
                if(j - 1 >= 0 && map[i][j - 1] != -1){
                    map[i][j] = (map[i][j] + map[i][j - 1]) % 1_000_000_007;
                } 
            }
        }
        
        return map[n - 1][m - 1];
    }
}