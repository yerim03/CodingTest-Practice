// 길이 5 이하
// 주어진 단어가 사전에서 몇 번째 단어인지 찾기

class Solution {
    
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static String word;
    static int cnt = 0;
    static int answer = 0;
    public int solution(String word) {
        
        this.word = word;
        dictionary("");
        
        return answer;
    }
    
    public void dictionary(String str) {
        
        if(str.length() == 5) {
            if(check(str)) {
                answer = cnt;
            }
            return;
        }
        for(int i = 0; i < 5; i++) {
            cnt++;
            if(check(str + alpha[i])) {
                answer = cnt;
                return;
            }
            dictionary(str + alpha[i]);
        }
    }
    
    public boolean check(String str) {
        if(str.equals(word)) return true;
        else return false;
    }
}
