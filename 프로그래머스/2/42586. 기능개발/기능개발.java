import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double)(100 - progresses[i]) / (double)(speeds[i]));
            
            if(!q.isEmpty() && q.peek() < day) {
                list.add(q.size());
                q.clear();
            }
            q.offer(day);
        }
        if(!q.isEmpty()) {
            list.add(q.size());
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}