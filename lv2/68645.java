// 삼각 달팽이

class Solution {
    public int[] solution(int n) {
        int[][] temp = new int[n][n];
        int count = 1;
        int i = -1;
        int j = 0;
        
        for (int k = 0; k < n; k++) {        
            for(int l = k; l < n; l++) {
                if(k % 3 == 0) {
                    i++;
                } else if(k % 3 == 1) {
                    j++;
                } else {
                    i--;
                    j--;
                }  
                temp[i][j] = count++;
            }   
        }    
        
        int[] answer = new int[--count];
        
        for(int k = n - 1; k >= 0; k--) {
            for (int l = k; l >= 0; l--) {
                answer[--count] = temp[k][l];
            }
        }
        
        return answer;
    }
}