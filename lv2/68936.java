// 쿼드압축 후 개수 세기

class Solution {
    int[][] board;
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        board = arr;
        
        search(0, arr.length - 1, 0 , arr.length - 1);
        
        return answer;
    }
    
    public void search(int si, int ei, int sj, int ej) {
        int half = (ei - si + 1) / 2;
        int wid = (ei - si + 1) * (ei - si + 1);
        int[] count = new int[2];
        
        for(int i = si; i <= ei; i++) {
            for(int j = sj; j <= ej; j++) {
                count[board[i][j]]++;
            }
        }
        
        if(count[0] == wid || count[1] == wid) {
            answer[board[si][sj]]++;
        } else if(half == 1) {
            answer[0] += count[0];
            answer[1] += count[1];
            return;
        } else {
            search(si, ei - half, sj, ej - half);
            search(si, ei - half, sj + half, ej);
            search(si + half, ei, sj, ej - half);
            search(si + half, ei, sj + half, ej);
        }
        
    }
}