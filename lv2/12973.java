//짝 지어 제거하기

import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            if(st.peek()==c){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        if(st.isEmpty()) return 1;
        return 0;
    }
}