//출차내역이 없으면 23:59에 출차된 것으로 간주
//차량번호가 작은 자동차부터 주차요금을 차례대로 출력

//초과한 시간이 단위시간으로 나누어 떨어지지 않으면 올림해서 계산
//같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않음
import java.util.*;

class Solution {
    
    HashMap<String, Integer> sumMap = new HashMap<>();
    HashMap<String, int[]> map = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        //시각, 차량번호, 내역별로 나누기
        for(String s : records) {
            String[] record = s.split(" ");
            String[] time = record[0].split(":");
            
            int hour = Integer.parseInt(time[0]);   //시간
            int minute = Integer.parseInt(time[1]); //분
            String number = record[1];  //차량번호
            String state = record[2];   //입출차 여부
            
            //"IN"이면 map에 삽입, "OUT"이면 map에서 같은 차량번호의 정보를 꺼내서 시간 계산
            if(state.equals("IN")) {
                map.put(number, new int[]{hour, minute});
            } else {
                int[] t = map.get(number);
                calculate(number, t[0], t[1], hour, minute);
            }
        }
        
        if(map.size() != 0) {
            ArrayList<String> list = new ArrayList<>(map.keySet());
            for(String key : list) {
                int[] t = map.get(key);
                calculate(key, t[0], t[1], 23, 59);
            }
        }
        
        //sumMap을 차량번호를 기준으로 내림차순 정렬
        ArrayList<String> keys = new ArrayList<>(sumMap.keySet());
        Collections.sort(keys);
        
        int[] answer = new int[sumMap.size()];
        int idx = 0;
        for(String key : keys) {
            int time = sumMap.get(key);
            
            int extraFee = 0;
            if(time > fees[0]) {
                double extraTime = Math.ceil((double)(time - fees[0]) / (double)fees[2]);
                extraFee = (int)extraTime * fees[3];
            }
            answer[idx] = fees[1] + extraFee;
            idx++;
        }
        
        return answer;
    }
    
    //차량별 총 주차 시간 계산
    public void calculate(String num, int inH, int intM, int outH, int outM) {          
        int tmp_h = outH - inH;
        int tmp_m = 0;
        if(outM < intM) {
            tmp_m = (60 + outM) - intM;
            tmp_h -= 1;
        } else {
            tmp_m = outM - intM;
        }

        int total = tmp_h * 60 + tmp_m;
        sumMap.put(num, sumMap.getOrDefault(num, 0) + total);
        map.remove(num); //map에서 같은 차량번호 정보 삭제
    }
}