//처음 라운드에서 a번인 참가자가 b번 참가자와 만나게 되는 라운드 번호
//a번은 b번과 만날때까지 항상 이긴다고 가정한다.
import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int start = 1, end = n;
        
        int x = 1;
        for(int i = 1; i <= 20; i++) {
            x *= 2;
            if(x == n) {
                answer = i;
                break;
            }
        }
        
        while(answer > 0) {
            int mid = (start + end) / 2;
            if((a <= mid && b > mid) || (a > mid && b <= mid)) {
                break;
            } else {
                if(a > mid && b > mid) {
                    start = mid + 1;
                } else if(a <= mid && b <= mid) {
                    end = mid;
                }
                answer--;
            }
        }
        return answer;
    }
}