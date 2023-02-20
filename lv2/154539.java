// 뒤에 있는 큰 수 찾기

import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < answer.length; i++) {
            while (!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                answer[st.pop()] = numbers[i];
            }
            
            st.push(i);
        }
        for (int i : st) {
            answer[i] = -1;
        }
        
        return answer;
    }
}