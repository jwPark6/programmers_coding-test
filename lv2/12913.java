class Solution {
    int solution(int[][] land) {
        int max = 0;
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(i == 0){
                        dp[i][j] = Math.max(dp[i][j], land[i][j]);
                        continue;
                    }
                    if(j != k){
                        dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                    }
                }
            }
        }
        
        for (int i = 0; i < 4; ++i) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        
        return answer;
    }
}