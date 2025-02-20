package dfs_bfs.괄호변환;

import java.util.Stack;

/**
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 *   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 *   4-3. ')'를 다시 붙입니다.
 *   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *   4-5. 생성된 문자열을 반환합니다.
 *   */
class Solution1 {
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

public class Main1 {
    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        System.out.println("올바른 괄호 문자열 p : " + solution1.solution("(()())()"));
    }
}
