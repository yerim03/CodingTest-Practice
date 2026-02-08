//k개의 귤을 고를 때, 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화해서 귤을 고른다
//서로 다른 종류의 수의 최소값을 구한다.
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i : tangerine) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            
        }
        
        List<Integer> valueSet = new ArrayList<>(hm.values());
        Collections.sort(valueSet, Collections.reverseOrder());
        
        int sum = 0;
        for(int i : valueSet) {
            sum += i;
            answer++;
            if(sum >= k) {
                break;
            }
        }
        return answer;
    }
}