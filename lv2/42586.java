import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        int day = 1;
        int count = 1;
        
        for(int i = 0; i < progresses.length;){
            if((progresses[i] + speeds[i] * day) >= 100){
                while(++i < progresses.length && (progresses[i] + speeds[i] * day) >= 100){
                    count++;
                }
                answer.add(count);
                count = 1;
            }
            else{
                day++;
            }
        }
        
        int[] is = answer.stream().mapToInt(i->i).toArray();
        return is;
    }
}