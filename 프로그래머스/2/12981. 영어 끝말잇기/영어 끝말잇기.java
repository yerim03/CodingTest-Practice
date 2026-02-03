import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];

        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            String before = words[i - 1];
            //이전에 등장했던 단어인 경우 or 앞사람이 말한 단어의 마지막 문자로 시작하는 단어가 아닌 경우
            if(list.contains(words[i]) || before.charAt(before.length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;//탈락하는 사람의 번호
                answer[1] = (i / n) + 1;    //차례
                return answer;
            }
            list.add(words[i]);
        }
        return answer;
    }
}