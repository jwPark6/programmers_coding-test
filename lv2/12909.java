import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push('(');
            } else if (s.charAt(i)==')') {
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return answer;
    }
}