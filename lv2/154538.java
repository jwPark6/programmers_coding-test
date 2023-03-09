// 숫자 변환하기

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        q.offer(x);
        int size = q.size();
        int value = 0;
            
        while(!q.isEmpty()) {
            
            for (int i = 0; i < size; i++) {
                value = q.poll();
                if (value == y) return answer;
                
                if (value + n <= y && !s.contains(value + n)) {
                    q.offer(value + n);
                    s.add(value + n);
                }
                if (value * 2 <= y && !s.contains(value * 2)) {
                    q.offer(value * 2);
                    s.add(value * 2);
                }
                if (value * 3 <= y && !s.contains(value * 3)) {
                    q.offer(value * 3);
                    s.add(value * 3);
                }
            }
            
            size = q.size();
            answer++;     
        }
        
        return -1;
    }
}