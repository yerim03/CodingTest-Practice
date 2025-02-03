import java.util.*;

class Solution {
    private static String u = "", v = "";

    public String solution(String p) {
        //1. 빈 문자열일 경우, 빈 문자열 그대로 반환
        if (p.isEmpty()) {
            return p;
        }

        //2. 문자열 w를 균형잡힌 괄호 문자열 u, v로 분리
        isBalance(p);

        //u가 "올바른 괄호 문자열"인지 아닌지 확인
        if (isCorrect(u)) {     //3. u가 "올바른 괄호 문자열"일 경우
            return u + solution(v);
        } else {    //4. u가 "올바른 괄호 문자열"이 아닐 경우
            String re = reverse(u);
            return "(" + solution(v) + ")" + re;
        }
    }

    //균형잡힌 괄호 문자열 확인
    private static void isBalance(String p) {
        int left = 0, right = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {   //"("
                left++;
            } else {                    //")"
                right++;
            }

            if (left == right) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }
    }

    //올바른 괄호 문자열 확인
    private static boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    //u의 나머지 괄호 방향 뒤집기
    private static String reverse(String u) {
        u = u.substring(1, u.length()-1);
        u = u.replace('(', '.');
        u = u.replace(')', '(');
        u = u.replace('.', ')');
        return u;
    }

}