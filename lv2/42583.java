// 다리를 지나는 트럭

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        int cursor = 0;
        int curTruck = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        
        while (true) {
            answer++;
               
            if(q.size() == bridge_length){
                weight += q.poll();
            }
            
            curTruck = truck_weights[cursor]; 
            
            if(curTruck <= weight) {
                q.offer(curTruck);
                weight -= curTruck;
                cursor++;
            } else {
                q.offer(0);
            }
            
            if(cursor == truck_weights.length) break;
        }
        
        return answer;
    }
}