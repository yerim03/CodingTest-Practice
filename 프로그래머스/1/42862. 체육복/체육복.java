import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] students = new int[n+2];
        
        for(int i = 0; i < lost.length; i++) {
            students[lost[i]]--;  //-1
        }
        
        for(int i = 0; i < reserve.length; i++) {
            students[reserve[i]]++;   //1
        }
        

        for(int i = 1; i <= n; i++) {
            
            if(students[i] == -1) {     //도난 당한 학생
                //앞, 뒤 번호 학생이 여벌이 있을 경우
                if(students[i-1] == 1) {
                    students[i-1]--;
                    students[i]++;
                } else if (students[i+1] == 1) {
                    students[i+1]--;
                    students[i]++;
                } else {
                    continue;
                }
                answer++;
            } else if (students[i] >= 0) {  //도난당하지 않은 학생
                answer++;
            }
        }
        
        return answer;
    }
}