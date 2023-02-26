// 디스크 컨트롤러

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int[] temp;
        int cursor = 0;
        int curTime = 0;
        int count = 0;
        
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        while(count < jobs.length) {
            while(cursor < jobs.length && curTime >= jobs[cursor][0]) {
                pq.offer(jobs[cursor++]);
            }
            
            if (pq.isEmpty()) {
                curTime = jobs[cursor][0];
            } else {
                temp = pq.poll();
                answer += temp[1];
                if (curTime > temp[0]) answer += curTime - temp[0];
                curTime += temp[1];
                count++;
            }
        } 
        
        return (int) Math.floor(answer / jobs.length);
    }
}