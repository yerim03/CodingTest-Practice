package implementation.문자열압축;

import jdk.jshell.spi.SPIResolutionException;

import java.io.*;

/**
 * ababcdcdababcdcd -> 2ab2cd2ab2cd or2ababcdcd
 * abcabcdede -> abcabc2de(2개 단위), 3abcdede(3개 단위)
 * 1개 이상의 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이
 * */

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed_str = "";    //i개 단위로 압축한 문자열
            String pre_str = s.substring(0, i); //이전 문자열
            int cnt = 1;  //문자열의 연속 개수


            for (int j = i; j <= s.length(); j += i) {
                int end = Math.min(s.length(), j + i);  //인덱스는 문자열의 길이를 넘을 수 없다.
                String cur_str = s.substring(j, end);
                if (cur_str.equals(pre_str)) {  //자른 문자열 두 개가 같으면 연속 개수 카운트
                    cnt++;
                } else {    //같지 않으면 압축문자열에 압축한 문자 추가
                    compressed_str += (cnt > 1 ? cnt + pre_str : pre_str);  //cnt=1이면 1은 생략
                    cnt = 1;
                }
                pre_str = cur_str;  //이전 문자열을 현재 문자열로 바꾼다.
            }

            compressed_str += pre_str;  //i에 맞게 떨어지지 않은 마지막 문자 붙이기
            answer = Math.min(answer, compressed_str.length());
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        String s = "aabbaccc";
        System.out.println(solution.solution(s));
    }
}


/*
            for (int j = i; j <= s.length()-i; j += i) {
                    String cur_str = s.substring(j, j+i);

                    //자른 문자열 두 개가 같으면 연속 개수 카운트
                    if (cur_str.equals(pre_str)) {
                    cnt++;
                    } else {
                    compressed_str += (cnt > 1 ? cnt + pre_str : pre_str);
                    cnt = 1;
                    }
                    pre_str = cur_str;  //이전 문자열을 현재 문자열로 바꾼다.
                    }
*/


/*
            for (int j = i; j <= s.length()-i; j += i) {
                    String cur_str = s.substring(j, j + i);
                    System.out.println(j + " " + (j+1) + " " + pre_str + " " + cur_str);
                    pre_str = cur_str;
                    }*/
