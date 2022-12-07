import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int min1 = 0;
        int min2 = 0;  
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(!pq.isEmpty()){
            if(pq.peek() < K){
                min1 = pq.poll();
                if(pq.isEmpty()) return -1;
                min2 = pq.poll();
                pq.add(min1 + min2 * 2);
                answer++;
            } else{
                return answer;
            } 
        }
        
        return -1;
    }
}