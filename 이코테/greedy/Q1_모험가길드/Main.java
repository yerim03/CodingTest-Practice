package greedy.모험가길드;

import java.util.Arrays;
import java.util.Scanner;
/*
* 공포도가 X인 모험가는 반드시 X명 이상으로 구성된 그룹에 참여해야 한다.
* 그룹 수의 최대값을 구한다.
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] fears = new int[n];
        for (int i = 0; i < n; i++) {
            fears[i] = sc.nextInt();
        }

        Arrays.sort(fears);
        int group_cnt = 0;  //총 그룹의 수
        int member_cnt = 0;    //현재 그룹에 포함된 모험가의 수

        for (int fear : fears) {
            member_cnt++;   //현재 그룹에 모험가 포함한다.
            if(member_cnt >= fear) {    //현재 그룹의 모험가수 >= 현재 공포도 -> 이것을 만족하면 그룹을 결성할 수 있다.
                group_cnt++;            //그룹 count 증가
                member_cnt = 0;         //현재 그룹의 모험가 count 초기화
            }
        }
        System.out.println(group_cnt);
    }
}
