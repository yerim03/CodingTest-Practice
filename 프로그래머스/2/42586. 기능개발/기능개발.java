import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            double day = Math.ceil((double)(100 - progresses[i]) / (double)(speeds[i]));
            days[i] = (int) day;
        }
        
        int cnt = 1;
        int start = 0;
        for(int i = 1; i < days.length; i++) {
            if(days[start] >= days[i]) {
                cnt++;
            } else {
                list.add(cnt);
                start = i;
                cnt = 1;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}