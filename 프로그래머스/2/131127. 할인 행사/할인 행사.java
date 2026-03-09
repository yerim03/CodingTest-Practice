//회원대상으로 한가지 제품 할인 - 하루에 하나만 구매 가능
//원하는 제품, 수량이 할인하는 날짜와 회원자격 날짜와 일치하게 회원가입을 하려한다.
//회원등록 시 원하는 제품을 모두 할인받을 수 있는 등록 날짜의 총 일수
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        //첫째날의 연속 10일 세팅
        for(int i = 0; i < 10; i++) {
            hm.put(discount[i], hm.getOrDefault(discount[i], 0) + 1);
        }
        
        for(int start = 0; start <= discount.length - 10; start++) {
            boolean flag = false;
            
            //다음날 세팅
            if(start >= 1) {
                hm.put(discount[start - 1], hm.getOrDefault(discount[start - 1], 0) - 1);
                hm.put(discount[start + 9], hm.getOrDefault(discount[start + 9], 0) + 1);
            }
            
            for(int i = 0; i < want.length; i++) {
                if(hm.get(want[i]) != null && hm.get(want[i]) >= number[i]) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
            if(!flag)    answer++;       
        }
        return answer;
    }
}