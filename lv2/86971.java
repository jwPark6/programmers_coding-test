// 전력망을 둘로 나누기

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[][] graph;
    boolean[][] check;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        int x, y;
        graph = new int[n][n];
        
        for(int i = 0; i < wires.length; i++) {
            graph[wires[i][0] - 1][wires[i][1] - 1] = 1;
            graph[wires[i][1] - 1][wires[i][0] - 1] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            x = wires[i][0] - 1;
            y = wires[i][1] - 1;
            
            graph[x][y] = 0;
            graph[y][x] = 0;
            
            check = new boolean[n][n];
            answer = Math.min(Math.abs(bfs(x, n)), answer);
            
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int n, int len) {
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 1;
        int cur = 0;
        q.add(n);
            
        while(!q.isEmpty()) {
            cur = q.poll();
            
            for (int i = 0; i < graph.length; i++) {
                if(!check[cur][i] && !check[i][cur] && graph[cur][i] == 1) {
                    check[i][cur] = true;
                    check[cur][i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        
        return len - count * 2;
    }
}