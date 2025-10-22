import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        //map에 참가자 추가
        for(String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        //map에서 완주한 선수 제거
        for(String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }
        
        for(String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}