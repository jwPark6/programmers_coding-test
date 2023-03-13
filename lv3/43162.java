// 네트워크

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[computers.length];
        int value = 0;
        
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                q.offer(i);
                check[i] = true;
                answer++;
                
                while (!q.isEmpty()) {
                    value = q.poll();
                    
                    for (int j = 0; j < computers[value].length; j++) {
                        if (j != value && !check[j] && computers[value][j] == 1) {
                            q.offer(j);
                            check[j] = true;
                        }
                    }
                }
            }
        } 
        
        return answer;
    }
}