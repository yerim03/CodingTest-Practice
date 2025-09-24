import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {    
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if(strNumbers[0].equals("0")) {
            return "0";
        }
        
        for(int i = 0; i < strNumbers.length; i++) {
            answer += strNumbers[i];
        }
        return answer;
    }
}