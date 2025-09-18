class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int h = 1; h <= yellow; h++) {
            if(yellow % h != 0) continue;
            
            int w = yellow / h;
            
            if(2 * w + 2 * h + 4 == brown) {
                answer[0] = w + 2;  //가로
                answer[1] = h + 2;  //세로
                break;
            }
        }
        return answer;
    }
}