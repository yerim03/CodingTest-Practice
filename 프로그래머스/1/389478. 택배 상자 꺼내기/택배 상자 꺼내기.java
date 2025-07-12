class Solution {
    public int solution(int n, int w, int num) {
        int[] topFloor = new int[w];    //맨 윗층에 쌓인 택배상자 배열
        
        int floor = n / w;    //한 층에 w개가 모두 채워진 층의 개수
        int other = n % w;      //남은 택배 상자 수
        
        //맨 윗층에 남은 택배상자를 쌓는다.
        for(int i = 0; i < other; i++) {
            topFloor[i] = 1;
        }
        
        int totalFloor = 0; //num번 택배상자가 위치한 열에 쌓인 택배 상자의 총 개수
        int numFloor= (num - 1) / w  + 1;   //num번 택배상자의 층 수
        
        //totalFloor 구하기
        /*
        고려해야할 점
        1. 맨 윗층이 홀수 층인지 짝수 층인지
        2. num 번 택배상자가 홀수 층인지 짝수 층인지
        */
        if(floor % 2 == 0) { //floor이 짝수이면 맨 윗층은 홀수 층(오->왼)
            if(numFloor % 2 == 1) { //num이 홀수 층 -> topFloor과 num의 인덱스 동일
                totalFloor = floor + topFloor[(num - 1) % w];
            } else {    //num이 짝수 층 -> topFloor과 num의 인덱스 반대
                totalFloor = floor + topFloor[(w - 1) - (num - 1) % w];
            }
        } else {    //floor이 홀수이면 맨 윗층은 짝수 층(왼->오)
            if(numFloor % 2 == 1) { //num이 홀수 층 -> topFloor과 num의 인덱스 반대
                totalFloor = floor + topFloor[(w - 1) - (num - 1) % w];
            } else {    //num이 짝수 층 -> topFloor과 num의 인덱스 동일
                totalFloor = floor + topFloor[(num - 1) % w];
                
            }
        }
        
        //전체 츧수 - num번 택배상자의 층수 + 1
        int answer = totalFloor - numFloor + 1;
        return answer;
    }
}