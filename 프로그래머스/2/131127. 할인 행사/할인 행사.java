import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        //첫째날의 연속 10일 세팅
        for(int i = 0; i < 10; i++) {
            hm.put(discount[i], hm.getOrDefault(discount[i], 0) + 1);
        }
        
        int start = 0;
        int end = 9;
        while(end < discount.length) {
            if(check(hm, want, number))   answer++;
            
            //다음날 제품 세팅
            hm.put(discount[start], hm.getOrDefault(discount[start], 0) - 1);
            start++;
            end++;
            if(end < discount.length) {
                hm.put(discount[end], hm.getOrDefault(discount[end], 0) + 1);
            }
        }
        
        return answer;
    }
    
    public boolean check(Map<String, Integer> hm, String[] want, int[] number) {
        for(int i = 0; i < want.length; i++) {
            if(hm.getOrDefault(want[i], 0) != number[i]) return false;
        }
        return true;
    }
}