package binarySearch;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearchByRecursion(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;    //중간 값
        if(arr[mid] == target) {    //중간값과 찾고자 하는 값(target)이 같으면 중간값 반환
            return mid;
        } else if (arr[mid] > target) { //중간값이 찾고자 하는 값(target)보다 큰 경우 왼쪽 탐색
            return binarySearchByRecursion(arr, target, start, mid - 1);
        } else {    //중간값이 찾고자 하는 값(target)보다 작은 경우 오른쪽 탐색
            return binarySearchByRecursion(arr, target, mid + 1, end);
        }
    }

    /**
     * int[] arr : 정렬된 전체 배열
     * int target: 찾고자 하는 값
     * int start : 탐색 시작 인덱스
     * int end : 탐색 끝 인덱스
     * */
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;    //중간값
            if(arr[mid] == target) {        //중간값과 찾고자 하는 값(target)이 같으면 중간값 반환
                return mid;
            } else if (arr[mid] > target) { //중간값이 찾고자 하는 값(target)보다 큰 경우 왼쪽 탐색
                end = mid - 1;
            } else {                        //중간값이 찾고자 하는 값(target)보다 작은 경우 오른쪽 탐색
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearchByRecursion(arr, target, 0, n - 1);
        int result1 = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }
}
