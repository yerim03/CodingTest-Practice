import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                return -1;
            }
            int food1 = pq.poll();
            int food2 = pq.poll();
            
            int mix = food1 + (food2 * 2);
            pq.add(mix);
            cnt++;
        } 
        return cnt;
    }
}