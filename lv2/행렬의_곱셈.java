class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length; // 1
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        int[][] answer = new int[row1][col2];
          
        for(int i = 0; i < row1; i++){ // 2
            for(int j = 0; j < col2; j++){
                int temp = 0;
                for(int k = 0; k < col1; k++){
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}