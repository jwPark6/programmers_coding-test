// 게임 맵 최단거리

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean[][] visit;
    int[][] maps;
    Queue<Loc> q = new LinkedList<Loc>();
    int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    class Loc {
        int x;
        int y;
        int count;
        
        public Loc(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int x;
        int y;
        this.maps = maps;
        int n = maps.length;
        int m = maps[0].length;
        visit = new boolean[n][m];
        
        q.add(new Loc(0, 0, 1));
        
        while(!q.isEmpty()) {
            Loc l = q.poll();
            
            if(l.x == n - 1 && l.y == m - 1) {
                return l.count;
            }
            
            for (int i = 0; i < dir.length; i++) {
                x = l.x + dir[i][0];
                y = l.y + dir[i][1];
                
                if (x >= 0 && y >= 0 && x < n && y < m
                    && !visit[x][y] && maps[x][y] == 1) {
                    visit[x][y] = true;
                    q.add(new Loc(x, y, l.count + 1));
                }
            }
        }
        
        return -1;
    }
}