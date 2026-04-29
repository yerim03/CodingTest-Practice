import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> order = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(i);
            order.add(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            int idx = q.poll();
            int priority = order.poll();
            
            if(priorities[idx] == priority) {
                list.add(idx);
            } else {
                q.add(idx);
                order.add(priority);
            }
        }
        
        return list.indexOf(location) + 1;
    }
}