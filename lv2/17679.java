// [1차] 프렌즈 4 블록

class Solution {
    char[][] chars;
    boolean[][] bools;
    int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        chars = new char[m][n];
        bools = new boolean[m][n];
        int temp = 0;
        
        for(int i = 0; i < board.length; i++) {
            chars[i] = board[i].toCharArray();
        }
        
        while (true) {
            search(m, n);
            change(m, n);
            
            if(answer == temp) break;
            temp = answer;
        }
        
        return answer;
    }
    
    public void change(int m, int n) {
        String col = "";
        String blank = "";
        
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (!bools[i][j]) {
                    col += chars[i][j];
                } else {
                    answer++;
                    blank += " ";
                }
            }
            col += blank;
            
            for(int i = m - 1; i >= 0; i--) {
                chars[i][j] = col.charAt(m - 1 - i);
            }
            
            blank = "";
            col = "";
        }
        
        bools = new boolean[m][n];
    }
    
    public void search(int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (check(i, j)) {
                    bools[i][j] = true;
                    bools[i][j + 1] = true;
                    bools[i + 1][j] = true;
                    bools[i + 1][j + 1] = true;
                }
            }
        }
    }
    
    public boolean check(int x, int y) {
        return (chars[x][y] != ' '
                && chars[x][y] == chars[x][y + 1]
                && chars[x][y] == chars[x + 1][y]
                && chars[x][y] == chars[x + 1][y + 1]
               );
    }
}