package greedy.무지의먹방라이브;

import java.util.Collections;
import java.util.LinkedList;

class Solution1 {

    //음식을 (음식을 먹는데 걸리는 시간, 음식 순서) 순으로 묶어서 저장
    class Food {
        int time;
        int idx;

        Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }


    public int solution(int[] food_times, long k) {

        LinkedList<Food> foods = new LinkedList<>();
        int n = food_times.length;  //음식의 총 개수
        for (int i = 0; i < n; i++) {   //(음식을 먹는데 걸리는 시간, 음식 순서) 순으로 리스트에 저장
            foods.add(new Food(food_times[i], i + 1));
        }

        Collections.sort(foods, ((o1, o2) -> o1.time - o2.time));   //음식을 먹는데 걸리는 시간 순으로 오름차순 정렬

        int pretime = 0;    //현재 음식을 먹는데 걸리는 시간
        int idx = 0;    //현재 음식 순서
        for (Food f : foods) {
            long diff = f.time - pretime;   //(현재 음식을 먹는데 걸리는 시간) - (현재 시간)

            if (diff != 0) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                    pretime = f.time;
                } else {
                    k %= n;
                    foods.subList(idx, food_times.length).sort((o1, o2) -> o1.idx - o2.idx);    //남은 음식들을 원래 순서대로 다시 정렬
                    return foods.get(idx + (int) k).idx;
                }

            }
            idx++;
            n--;
        }

        return -1;
    }
}


public class Main1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        int[] food_times = {3, 5, 1, 6, 5, 3};
        int answer =sol.solution(food_times, 20);
        System.out.println(answer);
    }
}
