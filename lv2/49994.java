//방문 길이

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][] board = new boolean[21][21];
        String[] dir = dirs.split("");
        int x = 10;
        int y = 10;
        int tx = x;
        int ty = y;
        
        for(String s : dir){
            tx = x;
            ty = y;
            
            if (s.equals("U") && x + 1 < 21) {
                x += 2;
            } else if (s.equals("D") && x - 1 > 0) {
                x -= 2;
            } else if (s.equals("L") && y - 1 > 0) {
                y -= 2;
            } else if (s.equals("R") && y + 1 < 21){
                y += 2;
            }
            int cx = (tx + x) / 2; 
            int cy = (ty + y) / 2; 
            
            if(!board[cx][cy] && (cx + cy) % 2 != 0) {
                board[cx][cy] =true;
                answer++;
            }
        }
        
        return answer;
    } 
}