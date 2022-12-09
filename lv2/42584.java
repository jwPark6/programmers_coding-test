import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        int head = 0;
        int count = 0;
        
        for(int p : prices){
            q.offer(p);
        }
        
        while(!q.isEmpty()){
            head = q.poll();
            
            for(int i = count+1; i < prices.length; i++){
                answer[count]++;
                if(head > prices[i]){
                    break;
                }
            }
            count++;
        }
        
        return answer;
    }
}