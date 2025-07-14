//알아볼 수 없는 번호는 0
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCnt = 0;
        int luckyCnt = 0;
        for(int i= 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]) {
                    luckyCnt++;
                }
            }
        }
        
        answer[0] = (zeroCnt + luckyCnt) < 2 ? 6 : 7 - (zeroCnt + luckyCnt);
        answer[1] = luckyCnt < 2 ? 6 : 7 - luckyCnt;
        return answer;
    }
}