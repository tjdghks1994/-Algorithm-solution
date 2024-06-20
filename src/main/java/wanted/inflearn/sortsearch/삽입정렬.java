package main.java.wanted.inflearn.sortsearch;

import java.util.Arrays;
import java.util.Scanner;

public class 삽입정렬 {
    /**
     * 문제 : N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     *       정렬하는 방법은 삽입정렬입니다.
     *
     * 입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     *       두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.
     *       각 자연수는 정수형 범위 안에 있습니다.
     *
     * 출력 : 오름차순으로 정렬된 수열을 출력합니다.
     *
     * 예시 : 입력 - 6                  출력 -  5 7 11 13 15 23
     *            13 5 11 7 23 15
     */

    public static void solution(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                // 삽입 대상 원소가 앞 원소보다 작으면 자리 변경
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    // 삽입 대상 원소가 앞 원소보다 크면 종료
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr);
    }
}
