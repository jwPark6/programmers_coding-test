// 이중우선순위 큐

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> heap = new ArrayList<>();
        int[] answer = new int[2];
        String[] commands;
        
        for (int i = 0; i < operations.length; i++) {
            commands = operations[i].split(" ");
            
            if(commands[0].equals("I")) {
                heap.add(Integer.parseInt(commands[1]));
            } else if(heap.size() > 0 && commands[0].equals("D")) {
                Collections.sort(heap);
                if (commands[1].equals("1")) {
                    heap.remove(heap.size() - 1);
                } else if(commands[1].equals("-1")) {
                    heap.remove(0);
                }
            }
        }
        
        if(heap.size() == 0) return new int[]{0, 0};
        
        Collections.sort(heap);
        answer[0] = heap.get(heap.size() - 1);
        answer[1] = heap.get(0);
        
        return answer;
    }
}