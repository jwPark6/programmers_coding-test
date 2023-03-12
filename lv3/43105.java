// 정수 삼각형

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        int col = triangle[row - 1].length;
        int[][] max = new int[row][col];
        max[0][0] = triangle[0][0];
        
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j <= i; j++) {
                max[i + 1][j] = Math.max(max[i + 1][j], max[i][j] + triangle[i + 1][j]);
                max[i + 1][j + 1] = Math.max(max[i + 1][j + 1], max[i][j] + triangle[i + 1][j + 1]);
            }
        }
        
        for(int v : max[row-1]) {
            answer = Math.max(answer, v);
        }
        
        return answer;
    }
}