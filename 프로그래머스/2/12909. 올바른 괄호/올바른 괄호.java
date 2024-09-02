import java.util.*;

class Solution {
    boolean solution(String s) {
         boolean answer = true;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    return false;
                } else if (st.peek() == '(') {
                    st.pop();
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        if (!st.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}