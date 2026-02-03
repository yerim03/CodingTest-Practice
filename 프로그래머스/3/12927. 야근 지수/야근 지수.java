//야근피로도 = n시간동안 야근을 마친 후 남은 일의 각 작업량^2 을 모두 더한 값
//n시간동안 남은 작업을 처리할 때, 야근 피로도의 최솟값을 구한다.
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works) {
            pq.add(w);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            int poll = pq.poll();
            if((poll - 1) > 0) {
                pq.add(poll - 1);
            }
            n--;
        }
        
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += work * work;
        }
        return answer;
    }
}