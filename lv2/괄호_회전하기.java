import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean flag = false;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (c == '(' || c == '{' || c == '[') {
                    flag = true;
                    st.push(c);
                } else if (!st.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                    if (c - st.peek() == 1 || c - st.peek() == 2) {
                        st.pop();
                    }
                }
            }
            if (flag && st.isEmpty()) {
                answer++;
            }
            st.clear();
            s = s.substring(1, s.length()) + s.charAt(0);
        }
        return answer;
    }
}